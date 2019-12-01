package momonyan.t.mvvm_study.model.itemDataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}