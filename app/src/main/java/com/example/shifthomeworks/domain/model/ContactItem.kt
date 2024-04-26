package com.example.shifthomeworks.domain.model

data class ContactItem(


    val name:String=" ",
    val number:String,
    var id: Int = Unknown_ID


)
{
    companion object{
        const val Unknown_ID = 0
    }
}