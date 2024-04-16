package edu.skku.map.week7

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.AlarmClock
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val time = intent.getStringExtra(MainActivity.EXT_TIME)
        val desc = intent.getStringExtra(MainActivity.EXT_DESC)

        val textView = findViewById<TextView>(R.id.textView)

        // TextView의 텍스트 변경
        textView.text = "Do you want to set alarm on time $time with description '$desc'?"

        val btnOk = findViewById<Button>(R.id.button_Ok)
        btnOk.setOnClickListener {
            if (time != null) {
                createAlarm(desc.toString(), time.split(":")[0].toInt(), time.split(":")[1].toInt())
            }
            Handler(Looper.getMainLooper()).postDelayed({
                finish()
            },1000)

        }

        val btnCan = findViewById<Button>(R.id.button_Cancle)
        btnCan.setOnClickListener {
            setResult(RESULT_OK)  // 결과 설정
            finish()  // 액티비티 종료
        }
    }
}