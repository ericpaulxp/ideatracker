package com.example.ideafusion.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
@Entity(tableName = "idea_table")
data class Idea(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: Date = Date(System.currentTimeMillis()),
    val updatedAt: Date = Date(System.currentTimeMillis()),
): Parcelable {

}