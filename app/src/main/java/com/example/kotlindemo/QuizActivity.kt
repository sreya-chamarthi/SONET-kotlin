package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() ,View.OnClickListener{

    private var listofQuestions:ArrayList<Questions>?=null
    var currentPosition=1
    lateinit var question:TextView
    lateinit var submitbtn:Button
    lateinit var optionlist:List<TextView>
     var selectedChoice:Int=0
    var score:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        var utility=Utility()
        listofQuestions=utility.getQuestion()
        var name:String?=intent.getStringExtra("name")
        var q_name=findViewById<TextView>(R.id.q_name_)
        q_name.text=name

         question=findViewById<TextView>(R.id.q_question)
         val optionOne=findViewById<TextView>(R.id.tv_option_one)
         val optionTwo=findViewById<TextView>(R.id.tv_option_two)
         val optionThree=findViewById<TextView>(R.id.tv_option_three)
         val optionFour=findViewById<TextView>(R.id.tv_option_four)
         val progressBar=findViewById<ProgressBar>(R.id.q_progressbar)
        progressBar.max=listofQuestions!!.size
        progressBar.progress=currentPosition
        submitbtn=findViewById<Button>(R.id.q_btn_next)

        optionlist=listOf<TextView>(optionOne,optionTwo,optionThree,optionFour)
        setQuestion()
        for(option in optionlist){
            option.setOnClickListener(this)
        }

        submitbtn.setOnClickListener(View.OnClickListener{
            var ans=listofQuestions!!.get(currentPosition-1).answer
            val btnText:String=submitbtn.text.toString()
            when(btnText){
                "SUBMIT"->{
                    checkAnswer(ans,selectedChoice)
                    for(option in optionlist){
                        option.setClickable(false)
                    }
                    if(listofQuestions!!.size==currentPosition){
                        submitbtn.setText("FINISH")
                    }
                    else{
                        submitbtn.setText("NEXT")
                    }
                }
                "NEXT"->{
                    currentPosition++
                    setQuestion()
                    for(option in optionlist){
                        option.setClickable(true)
                    }
                    progressBar.progress=currentPosition
                }
                "FINISH"->{
                    Toast.makeText(this,"Your score is $score",Toast.LENGTH_LONG).show()
                    var intent=Intent(this,SonetQuiz()::class.java)
                    startActivity(intent)
                    finish()
                }            }

        })
    }
    private fun checkAnswer(ans:Int,selectedChoice:Int){
        when(selectedChoice){
            1->{
                optionlist.get(selectedChoice-1).background=ContextCompat.getDrawable(this,R.drawable.wrong_option_color)
                optionlist.get(ans-1).background=ContextCompat.getDrawable(this,R.drawable.right_option_color)
            }
            2->{
                optionlist.get(selectedChoice-1).background=ContextCompat.getDrawable(this,R.drawable.wrong_option_color)
                optionlist.get(ans-1).background=ContextCompat.getDrawable(this,R.drawable.right_option_color)
            }
            3->{
                optionlist.get(selectedChoice-1).background=ContextCompat.getDrawable(this,R.drawable.wrong_option_color)
                optionlist.get(ans-1).background=ContextCompat.getDrawable(this,R.drawable.right_option_color)
            }
            4->{
                optionlist.get(selectedChoice-1).background=ContextCompat.getDrawable(this,R.drawable.wrong_option_color)
                optionlist.get(ans-1).background=ContextCompat.getDrawable(this,R.drawable.right_option_color)
            }
        }
        if(ans==selectedChoice){
            score+=1
        }

    }
    fun setQuestion(){
        var questionObject=listofQuestions!!.get(currentPosition-1)

        question.text=questionObject.question
        optionlist.get(0).text=questionObject.optOne
        optionlist.get(1).text=questionObject.optTwo
        optionlist.get(2).text=questionObject.optThree
        optionlist.get(3).text=questionObject.optFour
        defaultOption()
        submitbtn.setText("SUBMIT")
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.tv_option_one->{
                selectedOption(optionlist.get(0),R.drawable.selected_option_border_bg)
                selectedChoice=1
            }
            R.id.tv_option_two->{
                selectedOption(optionlist.get(1),R.drawable.selected_option_border_bg)
                selectedChoice=2
            }
            R.id.tv_option_three->{
                selectedOption(optionlist.get(2),R.drawable.selected_option_border_bg)
                selectedChoice=3
            }
            R.id.tv_option_four->{
                selectedOption(optionlist.get(3),R.drawable.selected_option_border_bg)
                selectedChoice=4
            }
        }
    }
    private fun selectedOption(tv:TextView,id:Int){
        defaultOption()
        tv.background=ContextCompat.getDrawable(this,id)
        selectedChoice=id
    }
    private fun  defaultOption(){
        optionlist.get(0).background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionlist.get(1).background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionlist.get(2).background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        optionlist.get(3).background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
    }
}