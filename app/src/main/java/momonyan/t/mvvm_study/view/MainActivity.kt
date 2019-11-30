package momonyan.t.mvvm_study.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import momonyan.t.mvvm_study.R
import momonyan.t.mvvm_study.view_model.ContentViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewModel
        val viewModel = ViewModelProviders.of(this).get(ContentViewModel::class.java)
//        val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(ContentViewModel::class.java)
        //比較用
        var count: Int = 0
        //ボタンクリック
        button.setOnClickListener {
            count++
            viewModel.viewModelCount++
            viewModel.viewModelLiveDataCount.value = viewModel.viewModelLiveDataCount.value!! + 1

            //変換
            textView.text = count.toString()
            textView2.text = viewModel.viewModelCount.toString()
            textView3.text = viewModel.viewModelLiveDataCount.value.toString()
        }

        //オブザーバー
        val countObserver = Observer<Int> {
            textView3.text = viewModel.viewModelLiveDataCount.value.toString()
        }

        //オブザーバーセット。
        viewModel.viewModelLiveDataCount.observe(this, countObserver)

    }
}
