package com.example.oop_lab1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var work1Result: String? = null
    private var work2Result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.work1 -> {
                val dialog = InputDialogFragment { text ->
                    work1Result = text
                    var work1ResultText: TextView = findViewById(R.id.work1Result)
                    work1ResultText.text = work1Result?: "Текст відсутній"
                }
                dialog.show(supportFragmentManager, "dialogInput")
                true
            }
            R.id.work2 -> {
                val dialog = SliderDialogFragment { text ->
                    work2Result = text
                    var work2ResultText: TextView = findViewById(R.id.work2Result)
                    work2ResultText.text = work2Result?: "Чісло відсутнє"
                }
                dialog.show(supportFragmentManager, "dialogSlider")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}