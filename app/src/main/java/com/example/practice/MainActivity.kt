package com.example.practice



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginInText: EditText = findViewById(R.id.loginIn)
        val passwordIn: EditText = findViewById(R.id.passwordIn)
        val logIn: Button = findViewById(R.id.vhod)

        val supabase2 = createSupabaseClient(
            supabaseUrl = "https://secnuyibyxuofxthbooa.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InNlY251eWlieXh1b2Z4dGhib29hIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcwMTU3NzIyOSwiZXhwIjoyMDE3MTUzMjI5fQ.OdN4eFT9FFBt2nBwB0JzyEiDuDZMlO8paqmfZZmOt5g"
        ) {
            install(GoTrue)
            install(Postgrest)
        }


        logIn.setOnClickListener(){
            lifecycleScope.launch {
                supabase2.gotrue.verifyEmailOtp(type = OtpType.Email.INVITE, email = loginInText.text.toString(), token = "token")
            }
            val intent = Intent(this, AddAdress::class.java)
            startActivity(intent)

            }
        }
    }
















