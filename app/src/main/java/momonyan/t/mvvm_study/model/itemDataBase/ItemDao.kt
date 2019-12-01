package momonyan.t.mvvm_study.model.itemDataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item")
    fun getAll(): List<Item>

    @Query("SELECT * FROM Item WHERE itemId = :id")
    fun findById(id: Long): Item

    @Query("DELETE FROM Item WHERE itemId = :id")
    fun deleteById(id: Long)

    @Insert
    fun insert(item: Item)
}