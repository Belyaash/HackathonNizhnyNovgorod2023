package com.example.novgorod

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.novgorod.databinding.MeroprDetailActivityBinding
import kotlin.random.Random


class InfoActivity:AppCompatActivity() {
    private lateinit var binding: MeroprDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = MeroprDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var decriptionsList: List<String> = listOf<String>(
            "Представляем вашему вниманию ежегодное мероприятие от САФУ! Любая высшая школа, любой курс, приводите друзей!\n" +
                    "Приходите, будет круто!",
            "Совершенно новое мероприятие для данной сферы деятельности! Приходите с друзьями, крутые призы и именитые спонсоры!",
            "Собираем людей на достаточно интересное и полезное мероприятие.\n" +
                    "Новые знания и опыт обеспечены!"
        )

        val TitleView = findViewById<TextView>(R.id.mer_det_title)
        val AddressView = findViewById<TextView>(R.id.mer_det_address)
        val DateView = findViewById<TextView>(R.id.mer_det_date)
        val TimeView = findViewById<TextView>(R.id.mer_det_time)
        val DescView = findViewById<TextView>(R.id.mer_det_desc)
        val IcoView = findViewById<ImageView>(R.id.mer_det_ico)

        IcoView.setImageResource(intent.getIntExtra("ico", R.mipmap.narfu))
        TitleView.text = intent.getStringExtra("title")
        AddressView.text = intent.getStringExtra("address")
        DateView.text = intent.getStringExtra("date")
        TimeView.text = intent.getStringExtra("time")
        var i = Random.nextInt(0,2)
        DescView.text = decriptionsList[i]


        val Btn_zap = findViewById<TextView>(R.id.btn_zap)
        Btn_zap.setOnClickListener {

        val dialogClickListener =
            DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {}
                    DialogInterface.BUTTON_NEGATIVE -> {}
                }
            }

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage("Вы точно хотите записаться?").setPositiveButton("Да",
            { dialog, which ->
            Toast.makeText(applicationContext,
                "Вы успешно записаны!", Toast.LENGTH_SHORT).show()
        }).setNegativeButton("Нет", dialogClickListener).show()
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
