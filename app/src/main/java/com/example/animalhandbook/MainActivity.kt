package com.example.animalhandbook


import android.content.Intent
import android.content.res.TypedArray
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalhandbook.settings.SettingsActivity

import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var adapter : MyAdapter
    private val list = ArrayList<ListItem>()
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavAndDrawer()
        initRecyclerView()
        settingsChanges()
    }

    private fun initRecyclerView() {
        val rcView: RecyclerView = findViewById<RecyclerView>(R.id.rc_view)
        list.addAll(
            fillArray(
                resources.getStringArray(R.array.arr_wild_mammals),
                resources.getStringArray(R.array.arr_wild_mammals_c),
                getImageID(R.array.arr_wild_mammals_im)
            )
        )
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    private fun initNavAndDrawer() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val naView: NavigationView = findViewById<NavigationView>(R.id.nav_view)
        naView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            finish()
            val i = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(i)
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.nav_wild_mammals) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_wild_mammals),
                resources.getStringArray(R.array.arr_wild_mammals_c),
                getImageID(R.array.arr_wild_mammals_im)))
            supportActionBar?.setTitle(R.string.nav_wild_mammals)

        }
        if (item.itemId == R.id.nav_wild_predators) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_wild_predators),
                resources.getStringArray(R.array.arr_wild_predators_c),
                getImageID(R.array.arr_wild_predators_im)))
            supportActionBar?.setTitle(R.string.nav_wild_predators)

        }
        if (item.itemId == R.id.nav_dom_birds) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_dom_birds),
                resources.getStringArray(R.array.arr_dom_birds_c),
                getImageID(R.array.arr_dom_birds_im)))
            supportActionBar?.setTitle(R.string.nav_dom_birds)

        }
        if (item.itemId == R.id.nav_dom_hoofed) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_dom_hoofed),
                resources.getStringArray(R.array.arr_dom_hoofed_c),
                getImageID(R.array.arr_dom_hoofed_im)))
            supportActionBar?.setTitle(R.string.nav_dom_hoofed)

        }
        if (item.itemId == R.id.nav_red_mammals) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_red_mammals),
                resources.getStringArray(R.array.arr_red_mammals_c),
                getImageID(R.array.arr_red_mammals_im)))
            supportActionBar?.setTitle(R.string.nav_red_mammals)

        }
        if (item.itemId == R.id.nav_red_fish) {
            adapter.updateAdapter(fillArray(resources.getStringArray(R.array.arr_red_fish),
                resources.getStringArray(R.array.arr_red_fish_c),
                getImageID(R.array.arr_red_fish_im)))
            supportActionBar?.setTitle(R.string.nav_red_fish)
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun fillArray(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray): List<ListItem> {

        val listItemArray = ArrayList<ListItem>()

        for (n in 0 until titleArray.size){

            val listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    private fun getImageID(imageArrayID: Int): IntArray{

        val tArray: TypedArray = resources.obtainTypedArray(imageArrayID)
        val count = tArray.length()
        val ids = IntArray(count)

        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
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
                "Темно-зеленый" -> supportActionBar!!.setBackgroundDrawable(
                    ColorDrawable(
                        resources.getColor(
                            R.color.green_dark)))
            }
        }
    }
}
