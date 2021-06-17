package com.sunasterisk.loltournaments.ui.tournament

import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.databinding.FragmentTournamentDetailsBinding
import com.sunasterisk.loltournaments.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_tournament_details.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TournamentDetailsFragment : BaseFragment<FragmentTournamentDetailsBinding>() {
    override val layoutResource = R.layout.fragment_tournament_details
    override val viewModel by sharedViewModel<TournamentDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            tournamentViewModel = viewModel
        }

        arguments?.let {
            val arg = TournamentDetailsFragmentArgs.fromBundle(it)
            viewModel.getData(arg.tournament)
        }
    }

    override fun initActions() {
        binding.imageTournamentBack.setOnClickListener { findNavController().popBackStack() }
    }
}
