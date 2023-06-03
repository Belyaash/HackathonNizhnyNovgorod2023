package com.example.novgorod.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R
import com.example.novgorod.databinding.FragmentDashboardBinding
import com.example.novgorod.databinding.SavedFragmentBinding
import com.example.novgorod.rv_classes.Meropr
import com.example.novgorod.rv_classes.MeroprAdapter
import com.example.novgorod.rv_classes.SpacesItemDecoration

class DashboardFragment : Fragment() {

    private var _binding: SavedFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SavedFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rv: RecyclerView = binding.rvSaved
        val lst = createDummiesMeropr()
        val adapter = MeroprAdapter(lst,requireContext())

        rv.layoutManager = LinearLayoutManager(activity)
        rv.addItemDecoration(SpacesItemDecoration(8))
        rv.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun createDummiesMeropr(): List<Meropr> {
        val lst = listOf<Meropr>(
            Meropr("1 название", "Архангельск", "15:00 - 17:00", "21 апреля", R.mipmap.narfu),
            Meropr("2 название", "Архангельское", "16:00 - 17:00", "21 апреля", R.mipmap.narfu),
            Meropr("3 название", "Северодвинск", "12:00 - 17:00", "22 апреля", R.mipmap.narfu)
        )
        return lst
    }
}