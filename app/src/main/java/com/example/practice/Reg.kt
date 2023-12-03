package com.example.practice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val username: EditText = findViewById(R.id.username)
        val emailUser: EditText = findViewById(R.id.email_user)
        val passwordUser: EditText = findViewById(R.id.password_user)
        val regNewUs: Button = findViewById(R.id.regNewUser)

        regNewUs.setOnClickListener{
            val login = username.text.toString().trim()
            val email = emailUser.text.toString().trim()
            val password = passwordUser.text.toString().trim()



            }
        }





}