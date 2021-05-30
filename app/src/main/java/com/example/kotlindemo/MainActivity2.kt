package com.example.kotlindemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var layout=findViewById<ConstraintLayout>(R.id.container)
        var spinner=findViewById<Spinner>(R.id.spinner)
        var btn=findViewById<Button>(R.id.clr_btn)
        btn.setOnClickListener(View.OnClickListener {
            var colour:String = spinner.selectedItem.toString()
            when(colour){
                "Red" ->layout.setBackgroundColor(Color.RED)
                "Yellow"->layout.setBackgroundColor(Color.YELLOW)
                "Green" ->layout.setBackgroundColor(Color.GREEN)
                "Blue" ->layout.setBackgroundColor(Color.BLUE)

            }
        })

    }
}