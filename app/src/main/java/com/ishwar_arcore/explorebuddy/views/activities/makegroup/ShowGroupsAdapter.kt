package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ishwar_arcore.explorebuddy.R

class ShowGroupsAdapter(private val listOfGroups: MutableList<GroupJoinModel>) :
    RecyclerView.Adapter<ShowGroupsAdapter.GroupsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_join_group, parent, false)
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


        fun setData(model: GroupJoinModel) {
            tvBudgetRv.text = model.budget
            tvGenderPrefRv.text = model.prefer
            tvPlaceRv.text = model.place
            tvPlansRv.text = model.plan
            tvTransportRv.text = model.travel
        }
    }
}