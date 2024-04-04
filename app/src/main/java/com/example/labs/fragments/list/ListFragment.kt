package com.example.labs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.R

class ListFragment : Fragment() {
    private  lateinit var mNoteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mNoteViewModel.readAllNotes.observe(viewLifecycleOwner, Observer { note ->
            adapter.setData(note)
        })

        val button = view.findViewById<FloatingActionButton>(R.id.btn_add_new_note_from_list)
        button.setOnClickListener(){
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }
}
