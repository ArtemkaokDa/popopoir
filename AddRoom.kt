package com.example.smarthous

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smarthous.Rooms.AdapterRoom
import com.example.smarthous.Rooms.Room
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import java.lang.StringBuilder

class AddRoom : AppCompatActivity() {
    val viewItems = ArrayList<Room>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_room)

        val editText: EditText = findViewById(R.id.editNameRoom)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val save: Button = findViewById(R.id.save)

        save.setOnClickListener {
            val nameRoom = editText.text.toString()
            val intent = Intent(this, HomeAcran::class.java)

            lifecycleScope.launch {
                val city = SB.getClient().postgrest["ТипКомнаты"].select()
                val buf = StringBuilder()
                buf.append(city.body.toString()).append("\n")
                var array: JSONArray = JSONArray(buf.toString())

                try{
                    for (i in 0 until  array.length()){
                        val item = array.getJSONObject(i)
                        val id: Int = item.getInt("id_типа_комнаты")
                        val Иконка: String = item.getString("Иконка")
                        val БазовоеИмя: String = item.getString("БазовоеИмя")
                        val room = Room(id, Иконка, БазовоеИмя)
                        viewItems.add(room)
                    }
                } catch (e: JSONException){
                    Log.e("!!!", e.message.toString())
                }
            }

            recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
            val timer = object: CountDownTimer(3000, 1000){
                override fun onTick(millisUntilFinished: Long){}

                override fun onFinish(){
                    recyclerView.adapter = AdapterRoom(viewItems)
                }
            }
            timer.start()
        }
    }

    fun onBack (view: View){
        val intent = Intent(this, HomeAcran::class.java)
        startActivity(intent)
    }
}