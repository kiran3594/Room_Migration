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
        ).build()

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
                Log.d("MainActivity","$it")
            }
        }
    }
}