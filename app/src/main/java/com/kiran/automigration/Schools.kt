package com.kiran.automigration

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Schools(
    @PrimaryKey(autoGenerate = false)
    val name: String
)