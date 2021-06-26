package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.FragmentInitiateGroupBinding


class InitiateGroupFragment : Fragment() {

    private lateinit var sPlan: Spinner
    private lateinit var sBudget: Spinner
    private lateinit var sGender: Spinner
    private lateinit var sTravel: Spinner
    private lateinit var sGo: Spinner

    private lateinit var type: String
    private lateinit var budget: String
    private lateinit var prefer: String
    private lateinit var travel: String
    private lateinit var places: String


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
        sPlan = view.findViewById<Spinner>(R.id.sPlan)
        sBudget = view.findViewById(R.id.sBudget)
        sGender = view.findViewById(R.id.sGender)
        sTravel = view.findViewById(R.id.sTravel)
        sGo = view.findViewById(R.id.sGo)


        val arr = arrayOf("Item1","Item2")
        sPlan.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,arr)

        sPlan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"splan",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(),"nothing",Toast.LENGTH_SHORT).show()
            }

        }

        val arr2 = arrayOf("Item1","Item2")
        sBudget.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,arr)

        sBudget.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(), "splan", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(), "nothing", Toast.LENGTH_SHORT).show()
            }
        }


        /**   sPlan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
        ) {
        Toast.makeText(requireContext(), position, Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }

        } **/

        val arr3 = arrayOf("Item1","Item2")
        sGender.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,arr)

        sGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"splan",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(),"nothing",Toast.LENGTH_SHORT).show()
            }

        }

        val arr4 = arrayOf("Item1","Item2")
        sTravel.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,arr)

        sTravel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"splan",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(),"nothing",Toast.LENGTH_SHORT).show()
            }

        }

        val arr5 = arrayOf("Item1","Item2")
        sGo.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_spinner_item,arr)

        sGo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(),"splan",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(requireContext(),"nothing",Toast.LENGTH_SHORT).show()
            }

        }

        sPlan.setOnClickListener {

        }

    }

    companion object {
        fun newInstance() = InitiateGroupFragment()

    }

}