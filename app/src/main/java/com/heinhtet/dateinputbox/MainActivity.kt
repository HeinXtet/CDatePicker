package com.heinhtet.dateinputbox

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.heinhtet.dateinput.input.CDatePicker
import com.heinhtet.dateinput.input.CLDatePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CDatePicker.onFocusChangedListener {
    override fun onFocusChangedListener(hasFocus: Boolean) {
        requestedOrientation = if (hasFocus) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            ActivityInfo.SCREEN_ORIENTATION_USER
        }
    }
    private val DATE_FORMAT = "dd-MM-yyyy"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val minDate = CDatePicker.stringToDate("01-01-2000", DATE_FORMAT)
        val maxDate = CDatePicker.stringToDate("01-12-2018", DATE_FORMAT)
        val lazyDatePicker = findViewById<CLDatePicker>(R.id.lazyDatePicker)
        lazyDatePicker.setOnFocusChangedListener(this)
        lazyDatePicker.setMinDate(minDate)
        lazyDatePicker.setMaxDate(maxDate)
        show_btn.setOnClickListener {
            val fulldate = lazyDatePicker.formattedFullDate
            if (fulldate != null) {
                Log.d("Formatted Full date ", lazyDatePicker.formattedFullDate)
                fullFormated_date.text = lazyDatePicker.formattedFullDate
            }
        }
    }
}
