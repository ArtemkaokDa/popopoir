package com.example.practice

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest


class Db(){

    val supabase = createSupabaseClient(
        supabaseUrl = "https://secnuyibyxuofxthbooa.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InNlY251eWlieXh1b2Z4dGhib29hIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDE1NzcyMjksImV4cCI6MjAxNzE1MzIyOX0.B7NTnARJcEuiHFzKjMyblO85skW_t3YI1dmKZ3i1718"
    ) {
        install(GoTrue)
        install(Postgrest)
    }


//    val user = User(username = , Email = , Password =)
//    supabase.postgrest["User"].insert(city, returning = Returning.MINIMAL) //returning defaults to Returning.REPRESENTATION



}