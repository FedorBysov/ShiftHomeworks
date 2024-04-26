package com.example.shifthomeworks.presentation

import androidx.lifecycle.ViewModel
import com.example.shifthomeworks.domain.contactUseCase.DeleteContactItemUseCase
import com.example.shifthomeworks.domain.contactUseCase.GetContactListUseCase
import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.shifthomeworks.domain.contactUseCase.AddContactItemUseCase
import kotlinx.coroutines.launch


class ListContactsViewModel @Inject constructor(
    private val getContactListUseCase: GetContactListUseCase,
    private val deleteContactItemUseCase: DeleteContactItemUseCase ,
    private val addContactItemUseCase: AddContactItemUseCase
) : ViewModel() {

    val contactList = getContactListUseCase.getContactItemListUseCase()


    fun deleteContactList(contactItem: ContactItem) {
        viewModelScope.launch {
            deleteContactItemUseCase.deleteContactItemUseCase(contactItem)
        }
    }

    fun addShopItem(inputName: String, inputNumber: String) {
            viewModelScope.launch {
                val contactItem =  ContactItem(inputName, inputNumber )
                addContactItemUseCase.addContactItemUseCase(contactItem)
            }
    }

}


