package com.sunasterisk.loltournaments.ui.tournament

import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.databinding.FragmentTournamentTeamsBinding
import com.sunasterisk.loltournaments.ui.adapter.TeamAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TournamentTeamsFragment : BaseFragment<FragmentTournamentTeamsBinding>() {
    override val layoutResource = R.layout.fragment_tournament_teams
    override val viewModel by sharedViewModel<TournamentDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val teamAdapter = TeamAdapter(this::onTeamClick)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            tournamentViewModel = viewModel
            recyclerViewTeam.adapter = teamAdapter
        }
    }

    override fun initActions() {
    }

    private fun onTeamClick(team: Team) {
    }
}
