package com.example.shifthomeworks.domain.contactUseCase

import com.example.shifthomeworks.domain.Repository
import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject

class AddContactItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun addContactItemUseCase(contactItem: ContactItem){
        return repository.addContactItem(contactItem)
    }

}