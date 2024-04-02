package com.example.labs.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.labs.data.entities.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun readAllNotes() : LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)
}
