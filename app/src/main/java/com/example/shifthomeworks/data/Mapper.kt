package com.example.shifthomeworks.data

import com.example.shifthomeworks.domain.model.ContactItem
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapEntityToDbModel(contactItem: ContactItem): ContactDbModel = ContactDbModel(
        contactItem.id,
        contactItem.name,
        contactItem.number
    )

    fun mapDbModelToEntity(contactDbModel: ContactDbModel): ContactItem = ContactItem(


        contactDbModel.name,
        contactDbModel.number,
        contactDbModel.id
    )

    fun mapListDbModelToListEntityModel(list: List<ContactDbModel>) = list.map {
        mapDbModelToEntity(it)
    }

}