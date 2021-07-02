package com.sunasterisk.loltournaments.ui.favorite

import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.databinding.FragmentFavoriteBinding
import com.sunasterisk.loltournaments.ui.adapter.TeamAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override val layoutResource get() = R.layout.fragment_favorite
    override val viewModel by viewModel<FavoriteViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val teamAdapter = TeamAdapter(this::onTeamClick)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            favoriteViewModel = viewModel
            recyclerViewFavorite.adapter = teamAdapter
        }
        viewModel.getFavoriteTeams()
    }

    override fun initActions() {
    }

    private fun onTeamClick(team: Team) {
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToTeamDetailsFragment(team)
        )
    }
}
