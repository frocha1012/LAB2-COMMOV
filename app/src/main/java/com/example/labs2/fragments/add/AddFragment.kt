package com.example.Labs2.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.Labs2.R
import com.example.Labs2.data.entities.Note
import com.example.Labs2.data.vm.NoteViewModel

class AddFragment : Fragment() {
    private lateinit var mNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        ViewModelProvider(this)[NoteViewModel::class.java].also { this.mNoteViewModel = it }

        val button = view.findViewById<Button>(R.id.save)
        button.setOnClickListener {
            addNote()
        }

        val backButton = view.findViewById<Button>(R.id.backToList)
        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        return view
    }

    private fun addNote() {
        val noteText = view?.findViewById<EditText>(R.id.addNote)?.text.toString()
        val datePicker = view?.findViewById<DatePicker>(R.id.addDate)

        if (noteText.isEmpty()) {
            Toast.makeText(view?.context, getString(R.string.minNote), Toast.LENGTH_LONG).show()
        } else if (noteText.length < 5) {
            Toast.makeText(view?.context, getString(R.string.minNote), Toast.LENGTH_LONG).show()
        } else if (datePicker == null) {
            Toast.makeText(view?.context, getString(R.string.selectDate), Toast.LENGTH_LONG).show()
        } else {
            val day = datePicker.dayOfMonth
            val month = datePicker.month
            val year = datePicker.year

            val selectedDate = "$day/${month + 1}/$year"

            val note = Note(0, noteText, selectedDate)

            mNoteViewModel.addNote(note)

            Toast.makeText(requireContext(), getString(R.string.saved), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }
}
