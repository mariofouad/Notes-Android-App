package com.mario.notesapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//create table note (_id integer primary key autoincrement, details text)
@Entity("note")
class Note(
    @PrimaryKey(true)
    @ColumnInfo("_id")
    val id: Int = 0,
    @ColumnInfo("note_title")
    val noteTitle: String,
    @ColumnInfo("note_details")
    val noteDetails: String

)