package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity


class InitiateGroupFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var userId: String
    private lateinit var databaseRef: DatabaseReference

    private lateinit var sPlan: Spinner
    private lateinit var sBudget: Spinner
    private lateinit var sGender: Spinner
    private lateinit var sTravel: Spinner
    private lateinit var sGo: Spinner

    private lateinit var cardView: LinearLayout
    private lateinit var makeGroupActivity: MakeGroupActivity

    private lateinit var typeR: String
    private lateinit var budgetR: String
    private lateinit var preferR: String
    private lateinit var travelR: String
    private lateinit var placesR: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        makeGroupActivity = context as MakeGroupActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_initiate_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiViews(view)

        //Plans
        val plan = arrayOf("Trip", "Biking")
        sPlan.adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                plan
            )
        sPlan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> typeR = "Trip"
                    1 -> typeR = "Biking"
                }
                Toast.makeText(requireContext(), typeR, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }


        //Budget
        val budget = arrayOf("below 5000", "5000-10000", "10000-15000", "15000 above")
        sBudget.adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                budget
            )
        sBudget.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> budgetR = "5000"
                    1 -> budgetR = "10000"
                    2 -> budgetR = "15000"
                    3 -> budgetR = "20000"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }

        //Travel
        val travel = arrayOf("Bus", "Train", "Air")
        sTravel.adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                travel
            )
        sTravel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> travelR = "Bus"
                    1 -> travelR = "Train"
                    2 -> travelR = "Air"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }


        //preference
        val pref = arrayOf("Same Gender", "Gender not at all an issue")
        sGender.adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                pref
            )
        sGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> preferR = "same"
                    1 -> preferR = "different"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }


        //place
        val place = arrayOf("Beaches", "Mountains")
        sGo.adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                place
            )
        sGo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> placesR = "beaches"
                    1 -> placesR = "mountains"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }

        cardView.setOnClickListener {
            saveDataToFirebase()
        }

    }

    private fun intiViews(view: View) {
        mAuth = FirebaseAuth.getInstance()
        val firebaseUser = mAuth.currentUser
        if (firebaseUser != null) {
            userId = firebaseUser.uid
        }
        databaseRef = FirebaseDatabase.getInstance().reference
        sPlan = view.findViewById<Spinner>(R.id.sPlan)
        sBudget = view.findViewById(R.id.sBudget)
        sGender = view.findViewById(R.id.sGender)
        sTravel = view.findViewById(R.id.sTravel)
        sGo = view.findViewById(R.id.sGo)
        cardView = view.findViewById(R.id.btnGroup)
    }

    private fun saveDataToFirebase() {
        val makeGroupMap: HashMap<String, String> = HashMap<String, String>()
        makeGroupMap["id"] = userId
        makeGroupMap["travel"] = travelR
        makeGroupMap["prefer"] = preferR
        makeGroupMap["plan"] = typeR
        makeGroupMap["place"] = placesR
        makeGroupMap["budget"] = budgetR

        databaseRef.child("Makegroup").child(userId)
            .setValue(makeGroupMap)
            .addOnCompleteListener {
                startActivity(Intent(activity, HomeActivity::class.java))
                Toast.makeText(
                    requireContext(),
                    "Group created successfully !",
                    Toast.LENGTH_LONG
                ).show()

            }
            .addOnFailureListener {
                Toast.makeText(
                    requireContext(),
                    "Failed to creating group! Try again",
                    Toast.LENGTH_LONG
                ).show()

            }
    }


    companion object {
        fun newInstance() = InitiateGroupFragment()
    }

}