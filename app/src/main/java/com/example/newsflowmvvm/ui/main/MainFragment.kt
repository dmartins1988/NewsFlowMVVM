package com.example.newsflowmvvm.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsflowmvvm.R
import com.example.newsflowmvvm.data.observe
import com.example.newsflowmvvm.data.util.Result
import com.example.newsflowmvvm.extensions.gone
import com.example.newsflowmvvm.extensions.visible
import com.example.newsflowmvvm.model.Article
import com.example.newsflowmvvm.ui.adapter.ListAdapter
import com.example.newsflowmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(), ListAdapter.ListInteraction {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var listAdapter: ListAdapter

    override fun getLayoutId(): Int = R.layout.main_fragment

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        configureFlowObservers()
    }

    override fun onClick(article: Article, position: Int) {
    }

    private fun configureRecyclerView() {
        listAdapter = ListAdapter(context!!, this)
        recycler_view.apply {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }


    private fun configureFlowObservers() {

        viewModel.topNews.observe(this) { response ->
            when (response) {
                is Result.Success -> {
                    progress_bar.gone()
                    listAdapter.submitList(response.data.articles)
                }
                is Result.Loading -> {
                    progress_bar.visible()
                }
                is Result.Error -> {
                    recycler_view.gone()
                    progress_bar.gone()
                    empty_tv.visible()
                }
            }
        }

    }
}
