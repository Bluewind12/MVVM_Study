package momonyan.t.mvvm_study.view.view_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.count_activity_layout.*
import kotlinx.android.synthetic.main.count_activity_layout.view.*
import momonyan.t.mvvm_study.databinding.CountActivityLayoutBinding
import momonyan.t.mvvm_study.view_model.ContentViewModel

class CountFragment : Fragment() {

    private val viewModel: ContentViewModel by activityViewModels()

    private lateinit var fragmentListBinding: CountActivityLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentListBinding = CountActivityLayoutBinding.inflate(inflater, container, false).apply {
            viewModel = this@CountFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return fragmentListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    }
}
