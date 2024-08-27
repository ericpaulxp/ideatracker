package com.example.ideafusion.data

import com.example.ideafusion.domain.Idea
import com.example.ideafusion.domain.IdeaRepository
import com.example.ideafusion.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class IdeaRepositoryImpl @Inject constructor(
    private val dao: IdeaDao
) : IdeaRepository {
    override fun getIdeasById(id: Int): Flow<Idea> {
        return dao.getIdeaDetails(id)
    }

    override fun getAllIdeas(): Flow<Result<List<Idea>>> =
        dao.getAllIdeas().map { ideas ->
            ideas.map {
                Idea(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    createdAt = it.createdAt,
                    updatedAt = it.updatedAt
                )
            }
        }.transform { idea -> emit(Result.Success(idea)) }
            .catch { emit(Result.Success(emptyList())) }

    override suspend fun addIdea(idea: Idea): Result<String> = runCatching {
        dao.addIdea(idea)
        Result.Success("-")
    }.getOrDefault(Result.Error("sdad"))

    override suspend fun updateIdea(idea: Idea): Result<String> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteIdea(id: Int): Result<String> {
        TODO("Not yet implemented")
    }

    override suspend fun pinIdea(id: String): Result<String> {
        TODO("Not yet implemented")
    }
}