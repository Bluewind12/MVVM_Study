package momonyan.t.mvvm_study.ViewModel

import android.view.LayoutInflater
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ContentViewModel : ViewModel() {

    var viewModelCount: Int = 0

    private val _viewModelLiveDataCount = MutableLiveData(0)
    var viewModelLiveDataCount = _viewModelLiveDataCount

}