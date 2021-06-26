package com.ishwar_arcore.explorebuddy.views.activities.groupview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishwar_arcore.explorebuddy.data.model.JoinGroupClass
import com.ishwar_arcore.explorebuddy.databinding.ActivityViewGroupBinding
import com.ishwar_arcore.explorebuddy.views.activities.main.JoinGroupAdapter

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

        groupList.add(JoinGroupClass("Manali", "4", "No Vehicle"))
        groupList.add(JoinGroupClass("Kerala", "5", "Car"))
        groupList.add(JoinGroupClass("Shimla", "3", "Bus"))

    }
}