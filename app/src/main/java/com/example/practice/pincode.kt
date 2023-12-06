package com.example.practice


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView



//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//
//class pincode : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_pincode)

class pincode : AppCompatActivity() {

    var test1:String = "";
    lateinit var pa1:ImageView
    lateinit var pa2:ImageView
    lateinit var pa3:ImageView
    lateinit var pa4:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincode)

          pa1 = findViewById(R.id.Pa1)
        pa2 = findViewById(R.id.Pa2)
        pa3 = findViewById(R.id.Pa3)
        pa4 = findViewById(R.id.Pa4)
    }

    fun OnMyButtonClick(view: View){

        val test: Button = view as Button
        test1 += test.text.toString()
        Log.e("!", test1.toString())
        if(test1.length == 1){
            pa1.background = (getDrawable(R.drawable.gray))
        }
        if(test1.length == 2){
            pa2.background = (getDrawable(R.drawable.gray))
        }
        if(test1.length == 3){
            pa3.background = (getDrawable(R.drawable.gray))
        }
        if(test1.length == 4){
            pa4.background = (getDrawable(R.drawable.gray))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}