package com.sunasterisk.loltournaments.ui.team

import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Player
import com.sunasterisk.loltournaments.databinding.FragmentTeamDetailsBinding
import com.sunasterisk.loltournaments.ui.adapter.PlayerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDetailsFragment : BaseFragment<FragmentTeamDetailsBinding>() {
    override val layoutResource = R.layout.fragment_team_details
    override val viewModel by viewModel<TeamDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val playerAdapter = PlayerAdapter(this::onPlayerClick)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            teamViewModel = viewModel
            recyclerViewTeam.adapter = playerAdapter
        }

        arguments?.let {
            val arg = TeamDetailsFragmentArgs.fromBundle(it)
            viewModel.getTeam(arg.team)
        }
    }

    override fun initActions() {
        binding.imageTeamBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun onPlayerClick(player: Player) {
    }
}
