package momonyan.t.mvvm_study.model.itemDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM Item WHERE itemId = :id")
    fun findById(id: Long): List<Item>

    @Delete
    fun delete(item: Item): List<Item>
}