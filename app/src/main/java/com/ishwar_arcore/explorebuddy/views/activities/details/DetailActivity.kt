package com.ishwar_arcore.explorebuddy.views.activities.details

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.ishwar_arcore.explorebuddy.databinding.ActivityDetailBinding
import com.ishwar_arcore.explorebuddy.utils.Users
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity
import java.util.*
import kotlin.collections.HashMap

class DetailActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var userId: String
    private lateinit var databaseRef: DatabaseReference
    private lateinit var profilePicRef: StorageReference


    private lateinit var binding: ActivityDetailBinding

    private lateinit var userName: String
    private lateinit var userPhone: String
    private lateinit var userAge: String
    private lateinit var gender: String
    private lateinit var addressLine1: String
    private lateinit var addressLine2: String
    private lateinit var city: String
    private lateinit var state: String
    private lateinit var pinCode: String
    private lateinit var profileImage: String

    private lateinit var calendar: Calendar
    private lateinit var year: String
    private lateinit var month: String
    private lateinit var day: String
    private lateinit var age: String

    private lateinit var sex: RadioButton

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()

        binding.profileImage.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.etDateOFBirth.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener
                { view, year, monthOfYear, dayOfMonth ->
                    this.year = year.toString()
                    this.day = dayOfMonth.toString()
                    this.month = monthOfYear.toString()
                    binding.etDateOFBirth.text =
                        "${day.toString()} / ${month.toString()} / ${year.toString()}"

                }, year.toInt(), month.toInt(), day.toInt()
            )
            datePickerDialog.setTitle("select your date of birth")
            datePickerDialog.show()
        }

        binding.btnSave.setOnClickListener {
            getUserDetails()
        }

    }

    private fun initViews() {
        mAuth = FirebaseAuth.getInstance()
        val firebaseUser = mAuth.currentUser
        if (firebaseUser != null) {
            userId = firebaseUser.uid
        }
        profilePicRef = FirebaseStorage.getInstance().reference.child("Profile Images")
        databaseRef = FirebaseDatabase.getInstance().reference

        calendar = Calendar.getInstance()
        year = calendar[Calendar.YEAR].toString()
        month = calendar[Calendar.MONTH].toString()
        day = calendar[Calendar.DAY_OF_MONTH].toString()

    }

    @RequiresApi(Build.VERSION_CODES.P)
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            binding.profileImage.setImageURI(uri)
            val filePath: StorageReference = profilePicRef.child("$userId.jpg")
            if (uri != null) {
                val uploadTask: UploadTask = filePath.putFile(uri)
                binding.progressbar.visibility = View.VISIBLE
                uploadTask.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot?> {

                    Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show()

                    profilePicRef.child("$userId.jpg").downloadUrl.addOnSuccessListener(
                        OnSuccessListener<Uri> { uri ->
                            val url = uri.toString()
                            profileImage = url.toString()
                            Toast.makeText(this, "Stored", Toast.LENGTH_SHORT)
                                .show()
                            binding.progressbar.visibility = View.GONE

                        })
                })

            }
        }

    private fun getUserDetails() {
        binding.btnSave.playAnimation()
        binding.progressbar.visibility = View.VISIBLE
        age = (2021 - year.toInt()).toString()
        Log.d("tag", age)
        Toast.makeText(this, age.toString(), Toast.LENGTH_SHORT).show()
        val sexId = binding.radioGroup.checkedRadioButtonId
        sex = findViewById(sexId)
        Toast.makeText(this, sex.text, Toast.LENGTH_SHORT).show()

        userName = binding.etName.text.toString()
        gender = sex.text.toString()
        userAge = age.toString()
        addressLine1 = binding.etAddressLineOne.text.toString()
        addressLine2 = binding.etAddressLineTwo.text.toString()
        city = binding.etCity.text.toString()
        state = binding.etCity.text.toString()
        pinCode = binding.etPincode.text.toString()
        userPhone = binding.etPhoneNumber.text.toString()



        if (age.toInt() < 18) {
            Toast.makeText(this, "You are not adult !", Toast.LENGTH_SHORT).show()
            stopAnimation()
            return
        } else if (gender.isEmpty()) {
            Toast.makeText(this, "please select your gender !", Toast.LENGTH_SHORT).show()
            stopAnimation()
            return
        } else if (addressLine1.isEmpty()) {
            binding.etAddressLineOne.error = "please fill your address !"
            stopAnimation()
            return
        } else if (addressLine2.isEmpty()) {
            binding.etAddressLineTwo.error = "please fill your address !"
            stopAnimation()
            return
        } else if (city.isEmpty()) {
            binding.etCity.error = "please fill your city !"
            stopAnimation()
            return
        } else if (state.isEmpty()) {
            binding.etState.error = "please fill your state !"
            stopAnimation()
            return
        } else if (userName.isEmpty()) {
            binding.etName.error = "please fill your name !"
            stopAnimation()
            return
        } else if (userPhone.isEmpty()) {
            binding.etPhoneNumber.error = "please fill your phone number !"
            stopAnimation()
            return
        } else if (pinCode.isEmpty()) {
            binding.etPincode.error = "please fill your phone number !"
            stopAnimation()
            return
        } else {

            /** val users = Users(userId, profileImage, userName,
            gender, age, addressLine1, addressLine2,
            city, state, pinCode, userPhone
            )**/

            val userMap: HashMap<String, String> = HashMap<String, String>()
            userMap["id"] = userId
            userMap["profile"] = profileImage
            userMap["name"] = userName
            userMap["gender"] = gender
            userMap["age"] = userAge
            userMap["addressone"] = addressLine1
            userMap["addresstwo"] = addressLine2
            userMap["city"] = city
            userMap["state"] = state
            userMap["pincode"] = pinCode
            userMap["phonenumber"] = userPhone

            databaseRef.child("Users").child(userId)
                .setValue(userMap)
                .addOnCompleteListener {
                    Toast.makeText(
                        this,
                        "User has been registered successfully !",
                        Toast.LENGTH_LONG
                    ).show()
                    stopAnimation()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this,
                        "Failed to register! Try again",
                        Toast.LENGTH_LONG
                    ).show()
                    stopAnimation()
                }
        }
    }

    private fun stopAnimation() {
        binding.progressbar.visibility = View.GONE
        binding.btnSave.pauseAnimation()
    }

}