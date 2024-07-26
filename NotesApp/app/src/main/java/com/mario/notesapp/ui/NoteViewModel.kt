package com.mario.notesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mario.notesapp.database.Note
import com.mario.notesapp.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(app: Application): AndroidViewModel(app) {
    private val db = RoomDBHelper.getInstance(app)
    fun upsertNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            db.dao.upsertNote(note)
        }
    }
    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            db.dao.deleteNote(note)
        }
    }
    fun getNotes() = db.dao.getAllNotes()
}