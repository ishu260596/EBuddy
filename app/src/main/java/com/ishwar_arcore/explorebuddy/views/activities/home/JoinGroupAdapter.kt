package com.ishwar_arcore.explorebuddy.views.activities.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.data.model.JoinGroupClass
import com.ishwar_arcore.explorebuddy.databinding.JoingroupItemLayoutBinding
import com.ishwar_arcore.explorebuddy.views.activities.friends.ViewFriendsActivity
import org.w3c.dom.Text
import java.nio.channels.MembershipKey

class JoinGroupAdapter(private val groupsList: List<JoinGroupClass>,private var context: Context) :
    RecyclerView.Adapter<JoinGroupAdapter.JoinGroupViewHolder>() {



    inner class JoinGroupViewHolder(val binding: JoingroupItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoinGroupViewHolder {
        val view = JoingroupItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return JoinGroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: JoinGroupViewHolder, position: Int) {
        with(holder) {
            with(groupsList[position]) {
                binding.tvMembers.text = this.members
                binding.tvPlace.text = this.place
                binding.tvVehicles.text = this.vehicle
                binding.tvViewGroup.setOnClickListener {
                    val intent = Intent(context, ViewFriendsActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return groupsList.size
    }


}