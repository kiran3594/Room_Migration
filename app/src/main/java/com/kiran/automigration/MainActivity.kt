package com.kiran.automigration

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            UsersDatabase::class.java,
            "users.db"
        ).addMigrations(UsersDatabase.migration3To4).build()

        //Insert Users in Room database
//        (1..10).forEach() {
//            lifecycleScope.launch {
//                db.dao.insertUser(
//                    Users(
//                        emailId = "test$it@kirancorp.com",
//                        userName = "test$it"
//                    )
//                )
//            }
//        }

        //fetch Users in database
        lifecycleScope.launch {
            db.dao.getUsers().forEach {
                Log.d("MainActivity", "$it")
            }
        }


        //Insert Schools in Room database
//        (1..10).forEach() {
//            lifecycleScope.launch {
//                db.schoolsDao.insertSchools(
//                    Schools(
//                        name = "test$it"
//                    )
//                )
//            }
//        }

        //fetch Schools in database
        lifecycleScope.launch {
            db.schoolsDao.getSchools().forEach {
                Log.d("MainActivity", "$it")
            }
        }
    }
}