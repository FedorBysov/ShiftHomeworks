package com.example.shifthomeworks.domain

import androidx.lifecycle.LiveData
import com.example.shifthomeworks.domain.model.ContactItem

interface Repository {

    suspend fun addContactItem(contactItem: ContactItem)

    suspend fun deleteItem(contactItem: ContactItem)

    suspend fun editContactItem(contactItem: ContactItem)

    suspend fun getContactItem(id: Int): ContactItem

    fun getContactList(): LiveData<List<ContactItem>>
}