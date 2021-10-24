package com.example.linah_alkhurayyif_notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,"noteDataBase.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        if(db != null){
            db.execSQL("CREATE TABLE NotesTable (noteId text,note text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun addNote(note: Note): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put("noteId", note.note)

        val success = db.insert("NotesTable", null, contentValues)

        db.close()
        return success
    }
}