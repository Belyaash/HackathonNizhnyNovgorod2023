package com.example.novgorod.rv_classes

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.InfoActivity
import com.example.novgorod.R
import java.text.SimpleDateFormat


class MeroprAdapter(val NotesList: List<Meropr>, val context: Context):
    RecyclerView.Adapter<MeroprAdapter.NoteViewHolder>() {


    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnCreateContextMenuListener{
        private val MerName: TextView = itemView.findViewById(R.id.mer_name)
        private val MerAddress: TextView = itemView.findViewById(R.id.mer_adress)
        private val Time: TextView = itemView.findViewById(R.id.time)
        private val imageView2: ImageView = itemView.findViewById(R.id.imageView2)

        fun bind(note: Meropr){
            MerName.text = note.title
            MerAddress.text = note.address
            Time.text = note.time
            imageView2.setImageResource(note.Image)
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            view: View?,
            menuinfo: ContextMenu.ContextMenuInfo?
        ) {
            menu.add(this.adapterPosition, 1, 0, "Подробнее")
//            menu.add(this.adapterPosition, 2, 1, R.string.delete)
        }
    }

    fun getItem(position: Int): Meropr{
        return NotesList[position]
    }
//
//    fun removeItem(position: Int){
//        weatherNotesList.removeAt(position)
//        notifyDataSetChanged()
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mer_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(NotesList[position])
        holder.itemView.setOnClickListener {
            // создаем Intent для перехода на новую активность
            val intent = Intent(context, InfoActivity::class.java)
            // передаем данные в новую активность, если это необходимо
            val mer:Meropr = NotesList[position]
            intent.putExtra("ico", mer.Image)
            intent.putExtra("title", mer.title)
            intent.putExtra("address", mer.address)
            intent.putExtra("date", mer.date)
            intent.putExtra("time", mer.time)
            context.startActivity(intent)

            // запускаем новую активность
        }
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }
}