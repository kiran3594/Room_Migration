package com.kiran.automigration

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface SchoolsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchools(schools: Schools)

    @Query("SELECT * FROM SCHOOLS")
    suspend fun getSchools():List<Schools>
}