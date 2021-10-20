package com.example.voiceassistant.data


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AssistantDao {

    @Insert
    fun insert(assistant: Assistant)

    @Update
    fun update(assistant: Assistant)

    @Query("SELECT * FROM assistant_messages_table WHERE assistantId = :key")
    fun get(key: Long): Assistant?

    @Query("DELETE FROM assistant_messages_table")
    fun clear()

    @Query("SELECT * FROM assistant_messages_table ORDER BY assistantId DESC")
    fun getAllMessages(): LiveData<List<Assistant>>

    @Query("SELECT * FROM assistant_messages_table ORDER BY assistantId DESC LIMIT 1")
    fun getCurrentMessage(): Assistant?

}