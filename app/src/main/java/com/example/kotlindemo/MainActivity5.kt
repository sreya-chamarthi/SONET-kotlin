package com.example.kotlindemo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        var btn=findViewById<Button>(R.id.btn_5)
        var temperature=findViewById<EditText>(R.id.et1_5)
        var DirtRead=findViewById<EditText>(R.id.et2_5)
        var res=findViewById<TextView>(R.id.tv_5)
        btn.setOnClickListener(View.OnClickListener {
            var temp:Int=temperature.text.toString().toInt();
            var dirt:Int=DirtRead.text.toString().toInt();
            var day:String=randomDay()
            var food= fishfood(day)

            var isChangeWaterNeeded= shouldchangewater(day,temp,dirt)
            res.setText("1.Today is $day,u need to feed $food\n2.Change Water : ${if(isChangeWaterNeeded)"is needed" else "not needed"}")

        })
    }
    fun randomDay():String{
        var day:String=""
        var arr= arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        day=arr[Random().nextInt(arr.size)]
        return day

    }

    fun fishfood(day:String):String{
        var food=""
        when(day){
            "Monday"->food="flakes"
            "Tuesday"->food="pellets"
            "Wednesday"->food="redworms"
            "Thursday"->food="granules"
            "Friday"->food="mosquitoes"
            "Saturday"->food="lettuce"
            "Sunday"->food="plankton"
        }
        return food;
    }
    fun isHot(temp:Int)=temp>30
    fun isDirt(dirt:Int)=dirt>30
    fun isSunday(day:String)=day=="Sunday"
    fun shouldchangewater(day:String,temp:Int ,dirt:Int ):Boolean {
        return when{
            isHot(temp)->true
            isDirt(dirt)->true
            isSunday(day)->true
            else ->false
        }

    }
}