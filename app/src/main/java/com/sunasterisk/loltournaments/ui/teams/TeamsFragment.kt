package com.sunasterisk.loltournaments.ui.teams

import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.databinding.FragmentTeamsBinding
import com.sunasterisk.loltournaments.ui.adapter.TeamAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamsFragment : BaseFragment<FragmentTeamsBinding>() {
    override val layoutResource get() = R.layout.fragment_teams
    override val viewModel by viewModel<TeamsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val teamAdapter = TeamAdapter(this::onTeamClick)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            teamsViewModel = viewModel
            recyclerViewTeams.adapter = teamAdapter
        }
        if (viewModel.isSearchMode.value == false) viewModel.setSearchMode(false)
    }

    override fun initActions() {
    }

    private fun onTeamClick(team: Team) {
    }
}
