package com.example.bitfit


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CalorieDao {
    @Query("SELECT * FROM food")
    fun getAll(): Flow<List<Food>>

    @Insert
    fun insertAll(foodCal: List<Food>)

    @Insert
    fun insert(foodCal: Food)


    @Query("DELETE FROM food")
    fun deleteAll()


}
