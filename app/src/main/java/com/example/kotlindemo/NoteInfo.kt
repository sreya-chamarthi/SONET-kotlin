package com.example.kotlindemo

import android.widget.EditText

class NoteInfo(val course:CourseInfo,var title:String,var text: String) {
    override fun toString(): String {
        return "${course.title}-$title"
    }


}