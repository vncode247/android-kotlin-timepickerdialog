package com.vncode247.timepickerdialog

import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // store selected time
    private var selectedHour = 0
    private var selectedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTime = findViewById<TextView>(R.id.tvTime)
        tvTime.setOnClickListener {
            // get current time
            val currentTime = Calendar.getInstance()
            var hour = currentTime.get(Calendar.HOUR_OF_DAY)
            var minute = currentTime.get(Calendar.MINUTE)

            if (tvTime.text.isNotEmpty()) {
                hour = this.selectedHour
                minute = this.selectedMinute
            }

            // create listener
            val listener = TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                this.selectedHour = selectedHour
                this.selectedMinute = selectedMinute

                tvTime.text = "$selectedHour:$selectedMinute"
            }

            // create picker
            val timePicker = TimePickerDialog(this, listener, hour, minute, true)
            timePicker.show()
        }
    }
}
