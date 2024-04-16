package edu.skku.map.week7

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXT_TIME = "extra_key_time"
        const val EXT_DESC = "extra_key_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewActivity = findViewById<Button>(R.id.button)
        btnNewActivity.setOnClickListener {
            val editTextTime = findViewById<EditText>(R.id.editTextTime)
            val editTextDesc = findViewById<EditText>(R.id.editTextDesc)

            val time = editTextTime.text.toString()
            val description = editTextDesc.text.toString()

            val intent = Intent(this, Activity2::class.java).apply {
                putExtra(EXT_TIME, time)
                putExtra(EXT_DESC, description)
            }
            startActivity(intent)

            Handler(Looper.getMainLooper()).postDelayed({
                editTextTime.text.clear()
                editTextDesc.text.clear()
            },1000)
        }

    }
}