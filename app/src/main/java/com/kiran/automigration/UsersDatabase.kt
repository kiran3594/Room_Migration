package com.kiran.automigration

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Users::class],
    version = 2,
    autoMigrations = [AutoMigration(1, 2)]
)
abstract class UsersDatabase : RoomDatabase() {

    abstract val dao: UsersDao

}