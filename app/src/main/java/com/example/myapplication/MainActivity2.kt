package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        data class ListItem(val imageR: Int, val text: String, val action: String){

        }

        class AdapterList(context: Context, private val items: List<ListItem>) : ArrayAdapter<ListItem>(context, 0 ,items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val item = getItem(position)

                val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

                val imageView : ImageView = view.findViewById(R.id.ImageView)
                val textView : TextView = view.findViewById(R.id.tvList)

                item?.let {
                    imageView.setImageResource(it.imageR)
                    textView.text = it.text
                }
                return view
            }
        }

        val items = listOf(
            ListItem(R.drawable.album, "Публика выбирает сама - Место действия – дно Филадельф", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Бумажник", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Она будет с тобой, мой друг", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Бери, что дают", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Грустный понедельник", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Китайские улитки", "Action1"),
            ListItem(R.drawable.album, "Публика выбирает сама - Кого волнует этот дохлый аккумулятор", "Action1"),

        )

        val listView : ListView = findViewById(R.id.lvMain)

        val adapter = AdapterList(this, items)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = items[position]
            when(selectedItem.action) {
                "Action1" -> {
                    Toast.makeText(this, "автомат поставьте пожалуйста", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}