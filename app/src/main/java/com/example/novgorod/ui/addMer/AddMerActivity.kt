package com.example.novgorod.ui.addMer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.novgorod.R
import com.example.novgorod.rv_classes.Meropr


class AddMerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.add_mer_activity)

        val btn: Button = findViewById(R.id.create_mer)
        btn.setOnClickListener {
            Toast.makeText(this, "Запрос отправлен на подтверждение", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

//        rv?.addItemDecoration(itemSectionDecoration)


fun createDummiesMeropr(): List<Meropr>{
    val lst = listOf<Meropr>(
        Meropr("1 название", "Архангельск", "15:00 - 17:00", "21 апреля", R.mipmap.narfu),
        Meropr("1 название", "Архангельск", "15:00 - 17:00", "21 апреля", R.mipmap.narfu)
    )
    return lst

}
