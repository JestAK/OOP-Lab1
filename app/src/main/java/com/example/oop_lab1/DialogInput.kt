package com.example.oop_lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.widget.Button
import android.widget.EditText

class InputDialogFragment(
    private val onSubmit: (String) -> Unit
) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.dialog_input, container, false)
        val editTextInput: EditText = rootView.findViewById(R.id.editTextInput)
        val buttonOk: Button = rootView.findViewById(R.id.buttonOk)
        val buttonCancel: Button = rootView.findViewById(R.id.buttonCancel)

        buttonCancel.setOnClickListener {
            dismiss()
        }

        buttonOk.setOnClickListener {
            val result = editTextInput.text.toString()
            onSubmit(result)
            dismiss()
        }

        return rootView
    }
}