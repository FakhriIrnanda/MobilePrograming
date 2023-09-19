package com.example.mobileprograming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Deklarasi Variabel
    private lateinit var input_length: EditText
    private lateinit var input_width: EditText
    private lateinit var input_height: EditText
    private lateinit var tombol: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inisialisasi variabel
        input_length= findViewById(R.id.input_length)
        input_width= findViewById(R.id.input_width)
        input_height= findViewById(R.id.input_height)
        tombol= findViewById(R.id.tombol)
        result= findViewById(R.id.result)

        tombol.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.tombol) {
            var panjang = input_length.text.toString().trim()
            var lebar = input_width.text.toString().trim()
            var tinggi = input_height.text.toString().trim()
            val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
            result.text = volume.toString()
        }
    }
}