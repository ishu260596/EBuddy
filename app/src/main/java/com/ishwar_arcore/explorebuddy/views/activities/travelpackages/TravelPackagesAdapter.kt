package com.ishwar_arcore.explorebuddy.views.activities.travelpackages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ishwar_arcore.explorebuddy.databinding.TravelItemLayoutBinding

class TravelPackagesAdapter(private val packageList: List<PackageClass>) :
    RecyclerView.Adapter<TravelPackagesAdapter.TravelPackageViewHolder>() {

    class TravelPackageViewHolder(val binding: TravelItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelPackageViewHolder {
        val view =
            TravelItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TravelPackageViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelPackageViewHolder, position: Int) {
        with(holder) {
            with(packageList[position]) {
                binding.tvHotelName.text = this.hotel
                binding.tvPlaceHotel.text = this.place
                binding.tvCost.text = this.cost
                binding.tvNights.text = this.nights
            }
        }
    }

    override fun getItemCount(): Int {
        return packageList.size
    }
}