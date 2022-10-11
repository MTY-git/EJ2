package com.example.ej2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej2.databinding.ActivityMainBinding
import com.example.ej2.databinding.ActivityMainBinding.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = Adapter(locations){

            fun showMap(geoLocation: Uri) {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = geoLocation
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }

    }


    private val locations =
        listOf(
            Location("Caribe" , "https://loremflickr.com/320/240/caribe", ""),
            Location("Sevilla" , "https://loremflickr.com/320/240/seville" , ""),
            Location("Islandia" , "https://loremflickr.com/320/240/iceland" , ""),
            Location("Alaska" , "https://loremflickr.com/320/240/alaska" , ""),
            Location("Paris" , "https://loremflickr.com/320/240/paris" , ""),
            Location("Berlin" , "https://loremflickr.com/320/240/berlin" , ""),
            Location("Londres" , "https://loremflickr.com/320/240/london" , ""),
            Location("Madrid" , "https://loremflickr.com/320/240/madrid" , ""),
        )
}