package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input_result=findViewById<EditText>(R.id.input_radius)
        var btn = findViewById<Button>(R.id.btn)
        var txt = findViewById<TextView>(R.id.txtView);


        
        btn.setOnClickListener(View.OnClickListener() {

            // Code here executes on main thread after user presses button
            var radius:Double=input_result.text.toString().toDouble();
            val pi=3.141
            val area:Double=pi*radius*radius;
            txt.setText("Result:$area")

        });

    }
}