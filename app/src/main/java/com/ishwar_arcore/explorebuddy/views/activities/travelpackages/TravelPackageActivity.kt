package com.ishwar_arcore.explorebuddy.views.activities.travelpackages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.ActivityTravelPackageBinding
import com.ishwar_arcore.explorebuddy.databinding.TravelItemLayoutBinding

class TravelPackageActivity : AppCompatActivity() {


    private val packageList = mutableListOf<PackageClass>()
    lateinit var packagesAdapter: TravelPackagesAdapter

    private lateinit var binding: ActivityTravelPackageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTravelPackageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        packagesAdapter = TravelPackagesAdapter(packageList)
        binding.rvTravelPackages.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvTravelPackages.adapter = packagesAdapter

        packageList.add(PackageClass("Best Of Kashmir","Srinagar","19,900","5 Nights"))
        packageList.add(PackageClass("Captivating Kashmir","Srinagar","17,900","3 Nights"))
        packageList.add(PackageClass("Enchanting Kashmir","Kashmir","59,900","9 Nights"))
        packageList.add(PackageClass("Exotic Kashmir","Srinagar","10,000","6 Nights"))
        packageList.add(PackageClass("Explore Kashmir","Srinagar","9,900","5 Nights"))
        packageList.add(PackageClass("Fascinating Kashmir","Srinagar","14,000","6 Nights"))
        packageList.add(PackageClass("Heavenly Kashmir","Srinagar","20,900","5 Nights"))
        packageList.add(PackageClass("Splendors Of Kashmir","Srinagar","30,900","5 Nights"))


    }


}