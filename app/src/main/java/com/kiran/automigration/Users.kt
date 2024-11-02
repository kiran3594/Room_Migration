package com.kiran.automigration

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = false)
    val emailId: String,
    val userName: String,
    @ColumnInfo(name = "createdAt", defaultValue = "0")
    val createdAt: Long = System.currentTimeMillis()
)
