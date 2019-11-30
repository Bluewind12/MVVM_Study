package momonyan.t.mvvm_study.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ContentViewModel : ViewModel() {

    var viewModelCount: Int = 0

    private val _viewModelLiveDataCount = MutableLiveData(0)
    var viewModelLiveDataCount = _viewModelLiveDataCount

}