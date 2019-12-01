package momonyan.t.mvvm_study.repository

import momonyan.t.mvvm_study.model.itemDataBase.Item
import momonyan.t.mvvm_study.model.itemDataBase.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    fun getAll(): List<Item> {
        return itemDao.getAll()
    }

    fun getById(memoId: Long): Item {
        return itemDao.findById(memoId)
    }

    //スレッド
    suspend fun insert(memo: Item) {
        itemDao.insert(memo)
    }

}