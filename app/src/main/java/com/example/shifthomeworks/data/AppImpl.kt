package com.example.shifthomeworks.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.shifthomeworks.domain.Repository
import com.example.shifthomeworks.domain.model.ContactItem
import java.lang.reflect.Type
import java.net.Proxy
import javax.inject.Inject

class AppImpl @Inject constructor(
    private val contactDao: ContactDao,
    private val mapper: Mapper
): Repository {

    override suspend fun addContactItem(contactItem: ContactItem) {
        contactDao.addContactItem(mapper.mapEntityToDbModel(contactItem))
    }

    override suspend fun deleteItem(contactItem: ContactItem) {
        contactDao.deleteContactItem(contactItem.id)
    }

    override suspend fun editContactItem(contactItem: ContactItem) {
        contactDao.addContactItem(mapper.mapEntityToDbModel(contactItem))
    }

    override suspend fun getContactItem(id: Int): ContactItem {
        val dbModel = contactDao.getContactItem(id)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getContactList(): LiveData<List<ContactItem>> =
        contactDao.getContactList().map { dbList ->
            mapper.mapListDbModelToListEntityModel(dbList)
        }



}