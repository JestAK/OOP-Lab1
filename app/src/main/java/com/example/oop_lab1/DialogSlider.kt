package com.example.oop_lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class SliderDialogFragment(
    private val onSubmit: (String) -> Unit
) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.dialog_slider, container, false)
        val slider: SeekBar = rootView.findViewById(R.id.slider)
        val sliderLabel: TextView = rootView.findViewById(R.id.textViewSliderValue)
        val buttonOk: Button = rootView.findViewById(R.id.buttonOk)
        val buttonCancel: Button = rootView.findViewById(R.id.buttonCancel)

        buttonCancel.setOnClickListener {
            dismiss()
        }

        buttonOk.setOnClickListener {
            val result = slider.progress.toString()
            onSubmit(result)
            dismiss()
        }

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sliderLabel.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?){}

            override fun onStopTrackingTouch(seekBar: SeekBar?){}
        })

        return rootView
    }
}