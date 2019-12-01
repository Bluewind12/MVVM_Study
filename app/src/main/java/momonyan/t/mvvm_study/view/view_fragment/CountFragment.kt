package momonyan.t.mvvm_study.view.view_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import momonyan.t.mvvm_study.R
import momonyan.t.mvvm_study.view_model.ContentViewModel

class CountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_main, container, false)
        //ViewModel
        val viewModel = ViewModelProviders.of(this).get(ContentViewModel::class.java)
        //比較用
        var count: Int = 0
        //ボタンクリック
        button.setOnClickListener {
            count++
            viewModel.viewModelCount++
            viewModel.viewModelLiveDataCount.value = viewModel.viewModelLiveDataCount.value!! + 1

            //変換
            view.textView.text = count.toString()
            view.textView2.text = viewModel.viewModelCount.toString()
            view.textView3.text = viewModel.viewModelLiveDataCount.value.toString()
        }

        //オブザーバー
        val countObserver = Observer<Int> {
            view.textView3.text = viewModel.viewModelLiveDataCount.value.toString()
        }

        //オブザーバーセット。
        viewModel.viewModelLiveDataCount.observe(viewLifecycleOwner, countObserver)

        return view
    }
}
