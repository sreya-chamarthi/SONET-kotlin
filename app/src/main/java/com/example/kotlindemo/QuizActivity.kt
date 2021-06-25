package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() ,View.OnClickListener{

    private var listofQuestions:ArrayList<Questions>?=null
    var currentPosition=1
    lateinit var question:TextView
    lateinit var optionOne:TextView
    lateinit var optionTwo:TextView
    lateinit var optionThree:TextView
    lateinit var optionFour:TextView
    lateinit var submitbtn:Button
     var selectedChoice:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var utility=Utility()
        listofQuestions=utility.getQuestion()
        var name:String?=intent.getStringExtra("name")
        var q_name=findViewById<TextView>(R.id.q_name_)
        q_name.text=name

         question=findViewById<TextView>(R.id.q_question)
        optionOne=findViewById<TextView>(R.id.tv_option_one)
         optionTwo=findViewById<TextView>(R.id.tv_option_two)
         optionThree=findViewById<TextView>(R.id.tv_option_three)
         optionFour=findViewById<TextView>(R.id.tv_option_four)
        submitbtn=findViewById<Button>(R.id.q_btn_next)
        setQuestion()
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        submitbtn.setOnClickListener({
            var ans=listofQuestions.get(currentPosition-1).answer
            checkAnswer(ans:Int,id:Int)
        })
    }
    private fun checkAnswer(){

    }
    fun setQuestion(){
        var questionObject=listofQuestions!!.get(currentPosition-1)

        question.text=questionObject.question


        optionOne.text=questionObject.optOne

        optionTwo.text=questionObject.optTwo

        optionThree.text=questionObject.optThree

        optionFour.text=questionObject.optFour
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.tv_option_one->{
                selectedOption(optionOne,R.drawable.selected_option_border_bg)
            }
            R.id.tv_option_two->{
                selectedOption(optionTwo,R.drawable.selected_option_border_bg)
            }
            R.id.tv_option_three->{
                selectedOption(optionThree,R.drawable.selected_option_border_bg)
            }
            R.id.tv_option_four->{
                selectedOption(optionFour,R.drawable.selected_option_border_bg)
            }
        }
    }
    private fun selectedOption(tv:TextView,id:Int){
        defaultOption()
        tv.background=ContextCompat.getDrawable((this,id))
    }
    private fun  defaultOption(){
        optionOne.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionTwo.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionThree.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionFour.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
    }
}