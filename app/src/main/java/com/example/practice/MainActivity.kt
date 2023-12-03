package com.example.practice



import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun nextWindowReg(view: View){
        val randomIntent = Intent(this, Reg::class.java)
        startActivity(randomIntent)
    }



}