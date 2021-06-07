package com.example.kotlindemo

class Bicycle {
    var brandName:String=""
    //getter
    get(){
        return field
    }
    //setter
    set(value) {
        field=value
    }
    var modelYear:Int=0

    fun display(){
        println("$brandName -> $modelYear")
    }
}