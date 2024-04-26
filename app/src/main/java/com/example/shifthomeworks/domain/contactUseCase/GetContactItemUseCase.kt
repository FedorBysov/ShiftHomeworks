package com.example.shifthomeworks.domain.contactUseCase

import com.example.shifthomeworks.domain.Repository
import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject

class GetContactItemUseCase  @Inject constructor(private val repository: Repository) {

    suspend fun getContactItemUseCase(id: Int):ContactItem{
        return repository.getContactItem(id)
    }

}