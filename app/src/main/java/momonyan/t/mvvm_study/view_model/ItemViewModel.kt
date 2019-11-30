package momonyan.t.mvvm_study.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import momonyan.t.mvvm_study.model.ItemData
import kotlin.random.Random

class ItemViewModel : ViewModel() {

    //下側
    private val itemNames = listOf("消しゴム", "鉛筆", "りんご", "消費税")
    private val itemPrices = listOf(100, 200, 500, 10)

    private val _viewModelLiveDataItem = MutableLiveData(ItemData(itemNames[0], itemPrices[0]))
    var viewModelLiveDataItem = _viewModelLiveDataItem

    private var random = Random.nextInt(4)

    fun itemChangeData() {
        random = Random.nextInt(4)
        _viewModelLiveDataItem.value = ItemData(itemNames[random], itemPrices[random])
    }
}