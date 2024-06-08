package com.florian.ayrton.laboratoriocalificado03

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.florian.ayrton.laboratoriocalificado03.ui.activity.Ejercicio01Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, Ejercicio01Activity::class.java)
        startActivity(intent)
        finish()
    }
}
