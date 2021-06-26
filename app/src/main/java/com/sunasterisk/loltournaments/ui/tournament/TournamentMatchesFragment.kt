package com.sunasterisk.loltournaments.ui.tournament

import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Match
import com.sunasterisk.loltournaments.databinding.FragmentTournamentMatchesBinding
import com.sunasterisk.loltournaments.ui.adapter.MatchAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TournamentMatchesFragment : BaseFragment<FragmentTournamentMatchesBinding>() {
    override val layoutResource get() = R.layout.fragment_tournament_matches
    override val viewModel by sharedViewModel<TournamentDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val matchAdapter = MatchAdapter(this::onMatchClick)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            tournamentViewModel = viewModel
            recyclerViewMatch.adapter = matchAdapter
        }
    }

    override fun initActions() {
    }

    private fun onMatchClick(match: Match) {
    }
}
