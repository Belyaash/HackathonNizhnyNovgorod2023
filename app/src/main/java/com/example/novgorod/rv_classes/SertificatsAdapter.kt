package com.example.novgorod.rv_classes

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R


class SertificatsAdapter(val NotesList: List<Sertificats>):
    RecyclerView.Adapter<SertificatsAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener{
        private val sert_name: TextView = itemView.findViewById(R.id.sert_name)
        private val sert_place: TextView = itemView.findViewById(R.id.serf_place)
        private val sert_reg: TextView = itemView.findViewById(R.id.sert_reg)

        fun bind(note: Sertificats){
            sert_name.text = note.title
            sert_place.text = note.place
            sert_reg.text = note.region
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            view: View?,
            menuinfo: ContextMenu.ContextMenuInfo?
        ) {
            menu.add(this.adapterPosition, 1, 0, "Скачать")
            menu.add(this.adapterPosition, 2, 1, "Переслать")
        }
    }

    fun getItem(position: Int): Sertificats{
        return NotesList[position]
    }
//
//    fun removeItem(position: Int){
//        weatherNotesList.removeAt(position)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.doc_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(NotesList[position])
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}