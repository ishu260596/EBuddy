package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity

class ShowGroupsAdapter(
    private val listOfGroups: MutableList<GroupJoinModelRV>,
    val communication: Communication
) :
    RecyclerView.Adapter<ShowGroupsAdapter.GroupsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.make_group, parent, false)
        return GroupsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupsViewHolder, position: Int) {
        val model = listOfGroups[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return listOfGroups.size
    }

    inner class GroupsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlansRv = itemView.findViewById<TextView>(R.id.tvPlansRv)
        val tvBudgetRv = itemView.findViewById<TextView>(R.id.tvBudgetRv)
        val tvGenderPrefRv = itemView.findViewById<TextView>(R.id.tvGenderPrefRv)
        val tvTransportRv = itemView.findViewById<TextView>(R.id.tvTransportRv)
        val tvPlaceRv = itemView.findViewById<TextView>(R.id.tvPlaceRv)
        val joinGroupRv = itemView.findViewById<Button>(R.id.joinGroupRv)
        val custom = AlertDialog.Builder(itemView.context)
        val view = LayoutInflater.from(itemView.context).inflate(R.layout.custome_dialoge, null)
        val animation1 = view.findViewById<LottieAnimationView>(R.id.animationBSK)
        val btnSubmit = view.findViewById<LottieAnimationView>(R.id.btnSubmit)
        fun setData(model: GroupJoinModelRV) {
            tvBudgetRv.text = model.budget
            tvGenderPrefRv.text = model.prefer
            tvPlaceRv.text = model.place
            tvPlansRv.text = model.plan
            tvTransportRv.text = model.travel
            custom.setView(view)
            custom.setCancelable(true)
            val cusDi = custom.create()

            joinGroupRv.setOnClickListener {
                cusDi.show()
                btnSubmit.setOnClickListener {
                    btnSubmit.playAnimation()
                    communication.onClickOnMe()
                    cusDi.hide()
                }
            }
        }
    }
}