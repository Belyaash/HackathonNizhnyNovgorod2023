package com.example.novgorod.rv_classes

import android.provider.Contacts.People
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R


class UnofAdapter(val NotesList: List<UnofMeropr>):
    RecyclerView.Adapter<UnofAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener{
        private val MerName: TextView = itemView.findViewById(R.id.unof_title)
        private val MerAddress: TextView = itemView.findViewById(R.id.unof_address)
        private val Time: TextView = itemView.findViewById(R.id.unof_time)
        private val imageView2: ImageView = itemView.findViewById(R.id.unof_ico)
        private val People: TextView = itemView.findViewById(R.id.unof_people)

        fun bind(note: UnofMeropr){
            MerName.text = note.title
            MerAddress.text = note.address
            Time.text = note.time
            People.text = note.People
            imageView2.setImageResource(note.Image)
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

    fun getItem(position: Int): UnofMeropr{
        return NotesList[position]
    }
//
//    fun removeItem(position: Int){
//        weatherNotesList.removeAt(position)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_mer_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(NotesList[position])
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}