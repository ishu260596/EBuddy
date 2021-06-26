package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.FragmentInitiateGroupBinding


class InitiateGroupFragment : Fragment() {

    private lateinit var sPlan: Spinner
    private lateinit var sBudget: Spinner
    private lateinit var sGender: Spinner
    private lateinit var sTravel: Spinner
    private lateinit var sGo: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_initiate_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sPlan = view.findViewById(R.id.sPlan)
        sBudget = view.findViewById(R.id.sBudget)
        sGender = view.findViewById(R.id.sGender)
        sTravel = view.findViewById(R.id.sTravel)
        sGo = view.findViewById(R.id.sGo)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.plans,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sPlan.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.budget,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sBudget.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.prefer,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sGender.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.travel,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sTravel.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.place,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sGo.adapter = adapter
        }
    }

    companion object {
        fun newInstance() = InitiateGroupFragment()

    }

}