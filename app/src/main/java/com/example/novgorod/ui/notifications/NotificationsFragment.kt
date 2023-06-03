package com.example.novgorod.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.InfoActivity
import com.example.novgorod.R
import com.example.novgorod.databinding.ProfileBinding
import com.example.novgorod.rv_classes.*

class NotificationsFragment : Fragment() {

    private var _binding: ProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var adapter: MeroprAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = ProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rv_mer)
        val lst = createDummiesMeropr()
        adapter = MeroprAdapter(lst,requireContext())

        rv.layoutManager = LinearLayoutManager(activity)
        rv.addItemDecoration(SpacesItemDecoration(8))
        rv.adapter = adapter

        val btn_mer = view.findViewById<Button>(R.id.button_mer)
        btn_mer.setOnClickListener {
            disable_buttons(view)
            btn_mer.alpha = 1f
            val adapt = MeroprAdapter(lst,requireContext())

            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = adapt
        }

        val btn_ach = view.findViewById<Button>(R.id.button_achievements)
        btn_ach.setOnClickListener {
            disable_buttons(view)
            btn_ach.alpha = 1f
            val adapt = AchievementAdapter(createDummiesAchievement())

            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = adapt
        }


        val btn_serf = view.findViewById<Button>(R.id.button_serf)
        btn_serf.setOnClickListener {
            disable_buttons(view)
            btn_serf.alpha = 1f
            val adapt = SertificatsAdapter(createDummiesCertificate())

            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = adapt
        }

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

    fun createDummiesAchievement(): List<Achievement> {
        val lst = listOf<Achievement>(
            Achievement("Первооткрыватель", "За участие в первом студенческом мероприятии или клубе.", R.drawable.ach1, true),
            Achievement("Капитан команды", "За руководство студенческой организацией или спортивной командой.", R.drawable.ach2, true),
            Achievement("Организатор-гуру", "За успешное проведение крупного студенческого мероприятия, такого как конференция или фестиваль.", R.drawable.ach3, false)
        )
        return lst
    }

    fun createDummiesCertificate(): List<Sertificats> {
        val lst = listOf<Sertificats>(
            Sertificats("Волейбол.pdf", "3 место", "Внутривузовское"),
            Sertificats("Шахматы.pdf", "2 место", "Региональное"),
            Sertificats("Акселератор.pdf", "2 место", "Внутривузовское")
        )
        return lst
    }

    fun disable_buttons(view: View){
        val btn_ach = view.findViewById<Button>(R.id.button_achievements)
        btn_ach.alpha = 0.5f

        val btn_mer = view.findViewById<Button>(R.id.button_mer)
        btn_mer.alpha = 0.5f

        val btn_serf = view.findViewById<Button>(R.id.button_serf)
        btn_serf.alpha = 0.5f
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