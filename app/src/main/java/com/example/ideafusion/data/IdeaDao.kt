package com.example.ideafusion.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ideafusion.domain.Idea
import kotlinx.coroutines.flow.Flow

@Dao
interface IdeaDao {

    @Query("SELECT * FROM idea_table")
    fun getAllIdeas(): Flow<List<Idea>>

    @Query("SELECT * FROM idea_table WHERE id = :id")
    fun getIdeaDetails(id: Int) : Flow<Idea>

    @Update
    fun updateNote(idea : Idea): Int

    @Delete
    fun deleteNotes(idea: Idea): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIdea(idea: Idea)



}