package com.example.acer.sharedpreference

import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val displayData = "Data";

    var input: EditText? = null;
    var display: TextView? = null;

    var sharedPreference : SharedPreferences? = null;
    var editor: SharedPreferences.Editor? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instance for sharedPreference
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(this);


        input = findViewById<EditText>(R.id.text_Input);
        display = findViewById<EditText>(R.id.display);
    }

    fun save(v: View?){
        editor = sharedPreference?.edit();
        // statement to save data
        editor?.putString(displayData,input?.text.toString());

        //statement to store
        editor?.apply();
    }
    fun load(v: View?){
        val data = sharedPreference?.getString(displayData,"Data not stored,yet")
        display?.text = data;
    }
}
