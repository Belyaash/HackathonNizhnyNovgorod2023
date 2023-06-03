package com.example.novgorod.rv_classes

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R

class AchievementAdapter(val NotesList: List<Achievement>):
    RecyclerView.Adapter<AchievementAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener{
        private val AchName: TextView = itemView.findViewById(R.id.ach_name)
        private val AchDesc: TextView = itemView.findViewById(R.id.ach_desc)
        private val AchImage: ImageView = itemView.findViewById(R.id.ach_ico)

        fun bind(note: Achievement){
            AchName.text = note.title
            AchDesc.text = note.desc
            AchImage.setImageResource(note.ico)
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            view: View?,
            menuinfo: ContextMenu.ContextMenuInfo?
        ) {
//            menu.add(this.adapterPosition, 1, 0, R.string.change)
//            menu.add(this.adapterPosition, 2, 1, R.string.delete)
        }
    }

    fun getItem(position: Int): Achievement{
        return NotesList[position]
    }
//
//    fun removeItem(position: Int){
//        weatherNotesList.removeAt(position)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.achievement_note_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(NotesList[position])
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}