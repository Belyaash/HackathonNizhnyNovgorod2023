package com.example.novgorod.ui.savedfragment

import android.content.Intent
import com.example.novgorod.ui.home.HomeViewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.InfoActivity
import com.example.novgorod.R
import com.example.novgorod.databinding.FragmentHomeBinding
import com.example.novgorod.databinding.SavedFragmentBinding
import com.example.novgorod.rv_classes.Meropr
import com.example.novgorod.rv_classes.MeroprAdapter
import com.example.novgorod.rv_classes.SpacesItemDecoration

class SavedFragment : Fragment() {

    private var _binding: SavedFragmentBinding? = null
    lateinit var adapter:MeroprAdapter
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
        adapter = MeroprAdapter(lst,requireContext())

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
            Meropr("Прослушивание группы Кино", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_studentyear),
            Meropr("Хакатон", "Архангельское", "16:00 - 17:00", "21 апреля", R.drawable.event_robots),
            Meropr("Субботник", "Северодвинск", "12:00 - 17:00", "22 апреля", R.drawable.event_cleaning)
        )
        return lst
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            1 -> {
                val intent = Intent(activity, InfoActivity::class.java)
                val mer:Meropr = adapter.getItem(item.groupId)
                intent.putExtra("ico", mer.Image)
                intent.putExtra("title", mer.title)
                intent.putExtra("address", mer.address)
                intent.putExtra("date", mer.date)
                intent.putExtra("time", mer.time)
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}