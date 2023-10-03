package com.example.mobileprograming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_switch: Button
    private lateinit var btn_data: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_switch= findViewById(R.id.btn_switch)
        btn_data= findViewById(R.id.btn_move_data)
        btn_switch.setOnClickListener(this)
        btn_data.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_switch -> {
                val move = Intent(this@MainActivity, activity_move::class.java)
                startActivity(move)
            }
            R.id.btn_move_data ->{
                val intentData = Intent(this@MainActivity, activity_move_with_data::class.java)
            }

        }
    }
}