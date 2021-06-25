package com.example.kotlindemo

class Utility {
    fun getQuestion():ArrayList<Questions>{
        var list=ArrayList<Questions>()
        var q1=Questions(1,"What is Kotlin?","Scripting Language","Programming language","Modern language","Assembly language",4)
        var q2=Questions(1,"What is Java?","Scripting Language","Programming language","Modern language","Assembly language",2)
        var q3=Questions(3,"What is Browser?","Apple software","Google tool","Desktop/mobile client","language",3)
        list.add(q1)
        list.add(q2)
        list.add(q3)
        return list;

    }

}