package com.kiran.automigration

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Users::class],
    version = 3,
    autoMigrations = [
        AutoMigration(1, 2),
        AutoMigration(2, 3, spec = UsersDatabase.Migration2To3::class)
]
)
abstract class UsersDatabase : RoomDatabase() {

    abstract val dao: UsersDao

    @RenameColumn(tableName = "Users", "created", "createdAt")
    class Migration2To3 : AutoMigrationSpec

}