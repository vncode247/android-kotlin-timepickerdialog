# android-kotlin-timepickerdialog
Android Kotlin TimePickerDialog

[![Android Kotlin TimePickerDialog](https://i.imgur.com/3Leq1JB.png)](https://youtu.be/43bkWcEn_gg)

```kotlin
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
```
