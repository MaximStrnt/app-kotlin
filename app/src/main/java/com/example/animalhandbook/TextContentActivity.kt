package com.example.animalhandbook

import androidx.appcompat.app.AppCompatActivity
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView




class TextContentActivity : AppCompatActivity() {

    private lateinit var textContent: TextView
    private lateinit var image: ImageView
    private lateinit var L: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_content)

        init()
        settingsChanges()
    }

    private fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textContent = findViewById(R.id.text_content_main)
        image = findViewById(R.id.type_image)
        textContent.text = intent.getStringExtra("content")
        image.setImageResource(intent.getIntExtra("image", R.drawable.deer))
        supportActionBar?.setTitle(intent.getStringExtra("title"))
    }

    private fun settingsChanges() {
        L = findViewById(R.id.bottom_square)
        val defPref = PreferenceManager.getDefaultSharedPreferences(this)

        val text = defPref.getString("main_text_size", "Medium")
        if (text != null) {
            when (text) {
                "Большой" -> textContent.textSize = 25f
                "Средний" -> textContent.textSize = 20f
                "Маленький" -> textContent.textSize = 15f
            }
        }

        val color = defPref.getString("main_text_color", "Grey")
        if (color != null) {
            when (color) {
                "Серый" -> textContent.setTextColor(resources.getColor(R.color.grey))
                "Черный" -> textContent.setTextColor(resources.getColor(R.color.black))
                "Коричневый" -> textContent.setTextColor(resources.getColor(R.color.brown))
                "Зеленый" -> textContent.setTextColor(resources.getColor(R.color.green))
                "Темно-зеленый" -> textContent.setTextColor(resources.getColor(R.color.green_dark))
            }

            val colorBack = defPref.getString("theme_color", "Black")
            if (colorBack != null) {
                when (colorBack) {
                    "Серый" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.grey)))
                        L.setBackgroundColor(resources.getColor(R.color.grey))
                    }
                    "Коричневый" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.brown)))
                        L.setBackgroundColor(resources.getColor(R.color.brown))
                    }
                    "Синий" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))
                        L.setBackgroundColor(resources.getColor(R.color.blue))
                    }
                    "Красный" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
                        L.setBackgroundColor(resources.getColor(R.color.red))
                    }
                    "Оранжевый" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.orange)))
                        L.setBackgroundColor(resources.getColor(R.color.orange))
                    }
                    "Зеленый" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green)))
                        L.setBackgroundColor(resources.getColor(R.color.green))
                    }
                    "Темно-зеленый" -> {
                        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green_dark)))
                        L.setBackgroundColor(resources.getColor(R.color.green_dark))
                    }
                }
            }
        }
    }
}










