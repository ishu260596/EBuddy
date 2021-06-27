package com.ishwar_arcore.explorebuddy.views.activities.groupview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.data.model.JoinGroupClass
import com.ishwar_arcore.explorebuddy.databinding.ActivityViewGroupBinding
import com.ishwar_arcore.explorebuddy.views.activities.main.JoinGroupAdapter
import com.ramotion.foldingcell.FoldingCell

class ViewGroupActivity : AppCompatActivity() {

    private val groupList = mutableListOf<JoinGroupClass>()
    private lateinit var groupbinding: ActivityViewGroupBinding
    lateinit var groupsAdapter: JoinGroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        groupbinding = ActivityViewGroupBinding.inflate(layoutInflater)
        val view = groupbinding.root
        setContentView(view)


        groupbinding.rvJoinGroup.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        groupsAdapter = JoinGroupAdapter(groupList, this)
        groupbinding.rvJoinGroup.adapter = groupsAdapter

        groupList.add(JoinGroupClass("Manali","Aug 2 - Aug 15",R.drawable.manali))
        groupList.add(JoinGroupClass("Kerala", "July 4 - July 14",R.drawable.kerala))
        groupList.add(JoinGroupClass("Shimla", "July 2 - July 25", R.drawable.kashmir))

    }
}