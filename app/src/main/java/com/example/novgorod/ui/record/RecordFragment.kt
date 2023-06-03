package com.example.novgorod.ui.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R
import com.example.novgorod.databinding.RecordsFragmentBinding
import com.example.novgorod.rv_classes.*

class RecordFragment : Fragment() {

    private var _binding: RecordsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecordsFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rv_rec)
        val lst = createDummiesStudents()
        val adapter = RecordsAdapter(lst)

        rv.layoutManager = LinearLayoutManager(activity)
        rv.addItemDecoration(SpacesItemDecoration(8))
        rv.adapter = adapter

        val rec_btn_users = view.findViewById<Button>(R.id.rec_btn_users)
        rec_btn_users.setOnClickListener {
            disable_buttons(view)
            rec_btn_users.alpha = 1f
            val adapt = RecordsAdapter(lst)

            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = adapt
        }

        val rec_btn_kampus = view.findViewById<Button>(R.id.rec_btn_kampus)
        rec_btn_kampus.setOnClickListener {
            disable_buttons(view)
            rec_btn_kampus.alpha = 1f
            val adapt = RecordsAdapter(createDummiesKampuses())

            rv.layoutManager = LinearLayoutManager(activity)
            rv.adapter = adapt
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun disable_buttons(view: View) {
        val rec_btn_users = view.findViewById<Button>(R.id.rec_btn_users)
        rec_btn_users.alpha = 0.5f

        val rec_btn_kampus = view.findViewById<Button>(R.id.rec_btn_kampus)
        rec_btn_kampus.alpha = 0.5f

    }

    fun createDummiesStudents(): List<Records> {
        val lst = listOf<Records>(
            Records(
                "Андрей Б.",
                "Северный (Арктический) Федеральный Университет",
                "223 балла"
            ),
            Records(
                "Сергей Е.",
                "Северный (Арктический) Федеральный Университет",
                "223 балла"
            ),
            Records(
                "Максим К.",
                "Северный (Арктический) Федеральный Университет",
                "221 балла"
            ),
        )
        return lst
    }
    fun createDummiesKampuses(): List<Records> {
        val lst = listOf<Records>(
            Records(
                "САФУ",
                "Северный (Арктический) Федеральный Университет",
                "2230 балла"
            ),
            Records(
                "МГУ",
                "Московский государственный университет",
                "1560 балла"
            ),
            Records(
                "СГМУ",
                "Северный Государственный Медицинский Университет",
                "1559 балла"
            ),
        )
        return lst
    }
}