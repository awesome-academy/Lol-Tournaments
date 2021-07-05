package com.sunasterisk.loltournaments.ui.player

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.databinding.FragmentPlayerDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerDetailsFragment : BaseFragment<FragmentPlayerDetailsBinding>() {
    override val layoutResource get() = R.layout.fragment_player_details
    override val viewModel by viewModel<PlayerDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            playerViewModel = viewModel
        }

        val arg: PlayerDetailsFragmentArgs by navArgs()
        viewModel.setPlayer(arg.player)
    }

    override fun initActions() {
        binding.imagePlayerBack.setOnClickListener { findNavController().popBackStack() }
    }
}
