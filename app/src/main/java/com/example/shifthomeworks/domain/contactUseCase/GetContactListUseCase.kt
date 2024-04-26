package com.example.shifthomeworks.domain.contactUseCase

import androidx.lifecycle.LiveData
import com.example.shifthomeworks.domain.Repository
import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject

class GetContactListUseCase  @Inject constructor(private val repository: Repository) {
     fun getContactItemListUseCase():LiveData<List<ContactItem>>  {
        return repository.getContactList()
    }
}
