package com.example.foodnutrition

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFruits: RecyclerView
    private val list = ArrayList<Fruits>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruits = findViewById(R.id.rv_fruits)
        rvFruits.setHasFixedSize(true)

        list.addAll(getListFruits())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu : Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_about -> {
                startActivity(Intent(this, About::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListFruits() : ArrayList<Fruits>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//        val dataCalories = resources.getStringArray(R.array.data_calories)
        val listFruits = ArrayList<Fruits>()
        for (i in dataName.indices) {
            val fruits = Fruits(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFruits.add(fruits)
        }
        return listFruits
    }

    private fun showRecyclerList(){
        rvFruits.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruits.adapter = listFruitAdapter
    }
}