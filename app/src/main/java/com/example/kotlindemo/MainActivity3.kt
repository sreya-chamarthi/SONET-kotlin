package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var input_result=findViewById<EditText>(R.id.edt_txt)
        var btn = findViewById<Button>(R.id.button)
        var txt = findViewById<TextView>(R.id.txt_v)

        btn.setOnClickListener(View.OnClickListener {
            var n:Int=input_result.text.toString().toInt();
            var result:String=""
            for(i in 1..n){
                result=result+"$i@"
            }
            txt.setText(result)
        })
    }
}