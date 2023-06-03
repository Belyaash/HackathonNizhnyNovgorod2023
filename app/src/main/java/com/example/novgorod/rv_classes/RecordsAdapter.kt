package com.example.novgorod.rv_classes
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R


class RecordsAdapter(val NotesList: List<Records>):
    RecyclerView.Adapter<RecordsAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener{
        private val rec_name: TextView = itemView.findViewById(R.id.rec_name)
        private val rec_desc: TextView = itemView.findViewById(R.id.rec_desc)
        private val rec_points: TextView = itemView.findViewById(R.id.rec_points)

        fun bind(note: Records){
            rec_name.text = note.name
            rec_desc.text = note.desc
            rec_points.text = note.point
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            view: View?,
            menuinfo: ContextMenu.ContextMenuInfo?
        ) {
//            menu.add(this.adapterPosition, 1, 0, "Скачать")
//            menu.add(this.adapterPosition, 2, 1, "Переслать")
        }
    }

    fun getItem(position: Int): Records{
        return NotesList[position]
    }
//
//    fun removeItem(position: Int){
//        weatherNotesList.removeAt(position)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activist_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(NotesList[position])
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}