package momonyan.t.mvvm_study.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ContentViewModel : ViewModel() {

    var viewModelCount: Int = 0

    private val _viewModelLiveDataCount = MutableLiveData(0)
    var viewModelLiveDataCount = _viewModelLiveDataCount

    private var _onFabEvent = MutableLiveData<Boolean>(false)
    val onFabEvent: LiveData<Boolean> = _onFabEvent

    fun onFabClick() {
        _onFabEvent.value = true
    }
}