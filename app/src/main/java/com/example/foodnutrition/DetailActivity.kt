package com.example.foodnutrition

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


        val shareButton = findViewById<Button>(R.id.btn_share)
        shareButton.setOnClickListener {
            shareContent()
        }

        val fruits = intent.getParcelableExtra<Fruits>("key_fruit")

        val tvName = findViewById<TextView>(R.id.tv_item_name)
        tvName.text = fruits?.name


        val tvDescription = findViewById<TextView>(R.id.tv_item_description)
        tvDescription.text = fruits?.description


        val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
        fruits?.photo?.let {imgPhoto.setImageResource(it)}

        val tvCalories = findViewById<TextView>(R.id.tv_item_calories)
        tvCalories.text = "Calories: ${fruits?.calories}"

        val tvCalcium = findViewById<TextView>(R.id.tv_item_calcium)
        tvCalcium.text = "Calcium: ${fruits?.calcium}"

        val tvCarbs = findViewById<TextView>(R.id.tv_item_carbs)
        tvCarbs.text = "Carbs: ${fruits?.carbs}"
    }



    private fun shareContent(){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareMessage = "Konten yang ingin anda bagikan"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}