package com.example.practice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class Reg : AppCompatActivity() {
    @kotlinx.serialization.Serializable
    data class UserData (val Username: String = "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        val userName: EditText = findViewById(R.id.username)
        val emailUser: EditText = findViewById(R.id.email_user)
        val passwordUser: EditText = findViewById(R.id.password_user)
        val regNewUs: Button = findViewById(R.id.regNewUser)


        val supabase = createSupabaseClient(
            supabaseUrl = "https://secnuyibyxuofxthbooa.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InNlY251eWlieXh1b2Z4dGhib29hIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcwMTU3NzIyOSwiZXhwIjoyMDE3MTUzMjI5fQ.OdN4eFT9FFBt2nBwB0JzyEiDuDZMlO8paqmfZZmOt5g"
        ) {
            install(GoTrue)
            install(Postgrest)
        }


        regNewUs.setOnClickListener{

            val us = UserData(Username = userName.text.toString())
            lifecycleScope.launch {
                val user = supabase.gotrue.signUpWith(Email){
                    email = emailUser.text.toString()
                    password = passwordUser.text.toString()
                }
            }
            lifecycleScope.launch {
                supabase.postgrest["UsersData"].insert(us)
            }
            Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show()

        }
    }
}