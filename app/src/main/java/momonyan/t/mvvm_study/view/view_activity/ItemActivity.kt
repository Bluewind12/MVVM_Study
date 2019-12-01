package momonyan.t.mvvm_study.view.view_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import momonyan.t.mvvm_study.R
import momonyan.t.mvvm_study.databinding.ItemActivityLayoutBinding
import momonyan.t.mvvm_study.view_model.ItemViewModel

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ViewModelItem
        val itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)

        // DataBindingのインスタンスを作成（onCreateの外でもよい）
        val binding: ItemActivityLayoutBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        // ViewModelのインスタンスを作成を設定
        binding.viewModel = itemViewModel
        // ライフサイクル所有者を設定
        binding.lifecycleOwner = this
    }
}