package com.kiran.automigration

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Users::class,Schools::class],
    version = 4,
    autoMigrations = [
        AutoMigration(1, 2),
        AutoMigration(2, 3, spec = UsersDatabase.Migration2To3::class)
]
)
abstract class UsersDatabase : RoomDatabase() {

    abstract val dao: UsersDao
    abstract val schoolsDao: SchoolsDao

    @RenameColumn(tableName = "Users", "created", "createdAt")
    class Migration2To3 : AutoMigrationSpec

    companion object{
        val migration3To4=object : Migration(3,4){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE IF NOT EXISTS Schools(name CHAR NOT NULL PRIMARY KEY)")
            }
        }
    }

}