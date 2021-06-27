package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.ishwar_arcore.explorebuddy.R

class JoinGroupFragment : Fragment() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var userId: String
    private lateinit var databaseRef: DatabaseReference
    private lateinit var rvShowGroups: RecyclerView
    private lateinit var gAdapter: ShowGroupsAdapter
    private var listOfGroups = mutableListOf<GroupJoinModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        databaseRef.child("Makegroup").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                listOfGroups.clear()
                for (item in snapshot.children) {
                    val group: GroupJoinModel? = item.getValue(GroupJoinModel::class.java)
                    if (group != null) {
                        listOfGroups.add(group)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun initViews(view: View) {
        mAuth = FirebaseAuth.getInstance()
        val firebaseUser = mAuth.currentUser
        if (firebaseUser != null) {
            userId = firebaseUser.uid
        }
        rvShowGroups = view.findViewById(R.id.rvJoinGroup)
        gAdapter = ShowGroupsAdapter(listOfGroups)
        databaseRef = FirebaseDatabase.getInstance().reference
        rvShowGroups.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = gAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_join_group, container, false)
    }

    companion object {
        fun newInstance() = JoinGroupFragment()
    }
}