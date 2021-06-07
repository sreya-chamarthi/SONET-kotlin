package com.example.kotlindemo

class Person {
    var name:String? = null
    get()=field
    set(value) {
        field=value?.uppercase()
    }
    var gender:String? = null
    var age:Int = 0
    get() {
        return field
    }
    set(value) = if(value<18) field=0 else field=value


}