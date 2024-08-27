package com.example.ideafusion.domain

import kotlinx.coroutines.flow.Flow

interface IdeaRepository {

 fun getIdeasById(id: Int): Flow<Idea>
 fun getAllIdeas(): Flow<Result<List<Idea>>>

 suspend fun addIdea(idea: Idea): Result<String>

 suspend fun updateIdea(idea: Idea): Result<String>

 suspend fun deleteIdea(id: Int): Result<String>

 suspend fun pinIdea(id: String): Result<String>

}