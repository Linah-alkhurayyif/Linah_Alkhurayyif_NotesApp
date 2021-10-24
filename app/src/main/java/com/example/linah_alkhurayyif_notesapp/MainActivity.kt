package com.example.linah_alkhurayyif_notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var db: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = DatabaseHandler(this)
        note_btn.setOnClickListener { addNote() }
    }
    private fun addNote(){
        db.addNote(Note(0, note_et.text.toString()))
        note_et.text.clear()
        Toast.makeText(this, "Note Added successfully!!", Toast.LENGTH_LONG).show()
    }
}