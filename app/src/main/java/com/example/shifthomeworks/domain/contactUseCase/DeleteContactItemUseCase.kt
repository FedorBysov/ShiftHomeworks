package com.example.shifthomeworks.domain.contactUseCase

import com.example.shifthomeworks.domain.Repository
import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject

class DeleteContactItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun deleteContactItemUseCase(contactItem: ContactItem){
        return repository.deleteItem(contactItem)
    }
}