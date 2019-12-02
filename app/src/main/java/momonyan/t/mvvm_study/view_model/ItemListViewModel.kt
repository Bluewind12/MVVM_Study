package momonyan.t.mvvm_study.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import momonyan.t.mvvm_study.model.itemDataBase.Item
import momonyan.t.mvvm_study.repository.ItemRepository

class ItemListViewModel(private val repository: ItemRepository) : ViewModel() {
    private val _allItems = MutableLiveData<List<Item>>()
    val allItems: LiveData<List<Item>> = _allItems

    fun getAllItems() {
        _allItems.postValue(repository.getAll())
    }

}