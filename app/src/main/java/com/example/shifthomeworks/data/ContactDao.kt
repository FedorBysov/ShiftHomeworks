package com.example.shifthomeworks.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {

    @Query("SELECT * FROM storage_items")
    fun getContactList(): LiveData<List<ContactDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContactItem(contactDbModel: ContactDbModel)

    @Query("DELETE FROM storage_items WHERE id = :contactId")
    suspend fun deleteContactItem(contactId: Int)

    @Query("DELETE FROM storage_items")
    suspend fun deleteAll()

    @Query("SELECT * FROM storage_items WHERE id = :contactId LIMIT 1")
    suspend fun getContactItem(contactId: Int): ContactDbModel

}