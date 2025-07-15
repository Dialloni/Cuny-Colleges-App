package com.example.cunymapapp


import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class CollegeListFragment : Fragment() {

    private val colleges = listOf(
        "BMCC",
        "Baruch College",
        "Hunter College",
        "City College",
        "Lehman College",
        "John Jay College",
        "Queens College",
        "Brooklyn College"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_college_list, container, false)
        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, colleges)
        return view
    }
}
