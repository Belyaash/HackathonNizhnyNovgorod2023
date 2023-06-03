package com.example.novgorod.ui.all_mers

import android.content.Intent
import com.example.novgorod.ui.home.HomeViewModel


import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.InfoActivity
import com.example.novgorod.R
import com.example.novgorod.databinding.AllMersFragmentBinding
import com.example.novgorod.rv_classes.*
import com.example.novgorod.ui.addMer.AddMerActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class AllMersFragment : Fragment() {

    private var _binding: AllMersFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var adapter: MoroprAdapter2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = AllMersFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            val intent = Intent(activity, AddMerActivity::class.java)
            startActivity(intent)
        }
        val rv = view.findViewById<RecyclerView>(R.id.rv_mer2)
        val lst = createDummiesMeropr()
        adapter = MoroprAdapter2(lst,requireContext())

        rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv.addItemDecoration(SpacesItemDecoration(8))
        rv.adapter = adapter

        val btn_all = view.findViewById<Button>(R.id.btn_all)
        btn_all.setOnClickListener {
            disable_buttons(view)
            btn_all.alpha = 1f
            val adapter = MoroprAdapter2(lst,requireContext())
            rv.adapter = adapter
        }

        val btn_sport = view.findViewById<Button>(R.id.btn_sport)
        btn_sport.setOnClickListener {
            disable_buttons(view)
            btn_sport.alpha = 1f
            val adapter = MoroprAdapter2(createDummiesSport(),requireContext())
            rv.adapter = adapter
        }

        val btn_culture = view.findViewById<Button>(R.id.btn_culture)
        btn_culture.setOnClickListener {
            disable_buttons(view)
            btn_culture.alpha = 1f
            val adapter = MoroprAdapter2(createDummiesCulture(),requireContext())
            rv.adapter = adapter
        }

        val btn_science = view.findViewById<Button>(R.id.btn_science)
        btn_science.setOnClickListener {
            disable_buttons(view)
            btn_science.alpha = 1f
            val adapter = MoroprAdapter2(createDummiesScience(),requireContext())
            rv.adapter = adapter
        }

        val btn_volonteer = view.findViewById<Button>(R.id.btn_volonteer)
        btn_volonteer.setOnClickListener {
            disable_buttons(view)
            btn_volonteer.alpha = 1f
            val adapter = MoroprAdapter2(createDummiesVolonteers(),requireContext())
            rv.adapter = adapter
        }

        val rv2 = view.findViewById<RecyclerView>(R.id.rv_unof)
        val lst2 = createDummieUnod()
        val adapter2 = UnofAdapter(lst2)

        rv2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rv2.addItemDecoration(SpacesItemDecoration(8))
        rv2.adapter = adapter2
    }

//        rv?.addItemDecoration(itemSectionDecoration)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun disable_buttons(view: View){
        val btn_all = view.findViewById<Button>(R.id.btn_all)
        btn_all.alpha = 0.5f

        val btn_sport = view.findViewById<Button>(R.id.btn_sport)
        btn_sport.alpha = 0.5f

        val btn_culture = view.findViewById<Button>(R.id.btn_culture)
        btn_culture.alpha = 0.5f

        val btn_science = view.findViewById<Button>(R.id.btn_science)
        btn_science.alpha = 0.5f

        val btn_volonteer = view.findViewById<Button>(R.id.btn_volonteer)
        btn_volonteer.alpha = 0.5f
    }


    fun createDummiesMeropr(): List<Meropr> {
        val lst = createDummiesScience().plus(createDummiesSport()).plus(createDummiesCulture()).plus(createDummiesVolonteers())
        return lst
    }

    fun createDummiesSport(): List<Meropr> {
        val lst = listOf<Meropr>(
            Meropr("Волейбол", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_volleyball),
            Meropr("Футбол", "Архангельское", "16:00 - 17:00", "21 апреля", R.drawable.event_football),
            Meropr("Шахматы", "Северодвинск", "12:00 - 17:00", "22 апреля", R.drawable.event_robots)
        )
        return lst
    }

    fun createDummiesCulture(): List<Meropr> {
        val lst = listOf<Meropr>(
            Meropr("Teaтр", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_studentyear),
            Meropr("Кино", "Архангельское", "16:00 - 17:00", "21 апреля", R.drawable.event_siyanie),
        )
        return lst
    }

    fun createDummiesScience(): List<Meropr> {
        val lst = listOf<Meropr>(
            Meropr("Встреча СНО", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_robots),
        )
        return lst
    }

    fun createDummiesVolonteers(): List<Meropr> {
        val lst = listOf<Meropr>(
            Meropr("Субботник", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_cleaning),
        )
        return lst
    }
    fun createDummieUnod(): List<UnofMeropr> {
        val lst = listOf<UnofMeropr>(
            UnofMeropr("Волейбол", "Архангельск", "15:00 - 17:00", "21 апреля", R.drawable.event_volleyball, "3/10"),
            UnofMeropr("Футбол", "Архангельское", "16:00 - 17:00", "21 апреля", R.drawable.event_football, "2/12"),
            UnofMeropr("Шахматы", "Северодвинск", "12:00 - 17:00", "22 апреля", R.drawable.event_robots, "3/4")
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