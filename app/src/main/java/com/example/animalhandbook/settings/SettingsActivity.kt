package com.example.animalhandbook.settings


import android.content.Intent

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.animalhandbook.MainActivity
import com.example.animalhandbook.R


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = resources.getString(R.string.action_settings)
        settingsChanges()
       fragmentManager.beginTransaction().replace(android.R.id.content, SettingsFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Toast.makeText(this, "Настройки сохранены", Toast.LENGTH_SHORT).show()
            finish()
            val i = Intent(this@SettingsActivity, MainActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Настройки сохранены", Toast.LENGTH_SHORT).show()
        finish()
        val i = Intent(this@SettingsActivity, MainActivity::class.java)
        startActivity(i)
    }

    private fun settingsChanges() {
        val defPref = PreferenceManager.getDefaultSharedPreferences(this)
        val colorBack = defPref.getString("theme_color", "Black")
        if (colorBack != null) {
            when (colorBack) {
                "Серый" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.grey)))
                "Коричневый" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.brown)))
                "Синий" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))
                "Красный" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.red)))
                "Оранжевый" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.orange)))
                "Зеленый" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green)))
                "Темно-зеленый" -> supportActionBar!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.green_dark)))
            }
        }
    }
}

