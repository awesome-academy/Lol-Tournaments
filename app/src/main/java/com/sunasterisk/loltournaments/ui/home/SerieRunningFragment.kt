package com.sunasterisk.loltournaments.ui.home

import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Serie
import com.sunasterisk.loltournaments.databinding.FragmentSerieRunningBinding
import com.sunasterisk.loltournaments.ui.adapter.SerieAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SerieRunningFragment : BaseFragment<FragmentSerieRunningBinding>() {
    override val layoutResource = R.layout.fragment_serie_running
    override val viewModel by sharedViewModel<HomeViewModel>()

    override fun initViews() {}

    override fun initData() {
        val serieAdapter = SerieAdapter(this::onSerieClick)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            serieViewModel = viewModel
            recyclerSeriesCompleted.adapter = serieAdapter
        }
    }

    override fun initActions() {}

    private fun onSerieClick(serie: Serie) {
        findNavController().navigate(R.id.serieDetailFragment)
    }
}
