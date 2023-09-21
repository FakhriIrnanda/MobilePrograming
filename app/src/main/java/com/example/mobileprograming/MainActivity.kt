package com.example.mobileprograming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        private const val STATE_RESULT = "state_result"
    }

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
        if(savedInstanceState != null) {
            val hasil = savedInstanceState.getString(STATE_RESULT)
            result.text = hasil
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, result.text.toString())
        setContentView(R.layout.activity_main)
    }
    override fun onClick(v: View?) {
        if(v?.id == R.id.tombol) {
            var panjang = input_length.text.toString().trim()
            var lebar = input_width.text.toString().trim()
            var tinggi = input_height.text.toString().trim()
            var isEmptyFields = false
            /*
            memastikan apakah inputan masih ada yang kosong
             */
            if(panjang.isEmpty()){
                isEmptyFields = true
                input_length.error = "Field ini tidak boleh kosong"
            }
            if(lebar.isEmpty()){
                isEmptyFields = true
                input_width.error = "Field ini tidak boleh kosong"
            }
            if(tinggi.isEmpty()){
                isEmptyFields = true
                input_height.error = "Field ini tidak boleh kosong"
            }

            /*
           Jika semua inputan valid maka tampilkan hasilnya
            */
            if(!isEmptyFields){
                val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                result.text = volume.toString()
            }

        }
    }
}