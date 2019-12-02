package momonyan.t.mvvm_study.view.view_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import momonyan.t.mvvm_study.databinding.FragmentListLayoutBinding
import momonyan.t.mvvm_study.view.adapter.ItemListAdapter
import momonyan.t.mvvm_study.view_model.ItemListViewModel

class ItemViewFragment : Fragment() {
    private val viewModel: ItemListViewModel by activityViewModels()
    private lateinit var adapter: ItemListAdapter

    private lateinit var fragmentBinding: FragmentListLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentListLayoutBinding.inflate(inflater, container, false).apply {
            viewModel = this.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setRecyclerView() {
        val viewModel = fragmentBinding.viewModel
        if (viewModel != null) {
            adapter = ItemListAdapter(viewModel, view?.context!!)
            fragmentBinding.itemListRecyclerView.adapter = adapter
            fragmentBinding.itemListRecyclerView.addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}