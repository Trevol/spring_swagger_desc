package com.example.spring_swagger_desc

import com.example.spring_swagger_desc.entities.Entity1
import com.example.spring_swagger_desc.entities.Entity2
import com.fasterxml.classmate.TypeResolver

fun main(){
    TypeResolver().resolve(Entity1::class.java)
    TypeResolver().resolve(Entity2::class.java)
}