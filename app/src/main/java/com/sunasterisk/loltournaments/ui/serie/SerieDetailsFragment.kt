package com.sunasterisk.loltournaments.ui.serie

import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Tournament
import com.sunasterisk.loltournaments.databinding.FragmentSerieDetailsBinding
import com.sunasterisk.loltournaments.ui.adapter.TournamentAdapter
import kotlinx.android.synthetic.main.fragment_serie_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SerieDetailsFragment : BaseFragment<FragmentSerieDetailsBinding>() {
    override val layoutResource get() = R.layout.fragment_serie_details
    override val viewModel by viewModel<SerieDetailsViewModel>()

    override fun initViews() {
    }

    override fun initData() {
        val tournamentAdapter = TournamentAdapter(this::onTournamentClick)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            serieViewModel = viewModel
        }

        arguments?.let {
            val arg = SerieDetailsFragmentArgs.fromBundle(it)
            viewModel.setSerie(arg.serie)
            arg.serie.background?.let { serie -> imageSerieBackground.setImageResource(serie) }
            recyclerViewTournament.adapter = tournamentAdapter
        }
    }

    override fun initActions() {
        binding.let { imageSerieBack.setOnClickListener { onBackClick() } }
    }

    private fun onTournamentClick(tournament: Tournament) {
        findNavController().navigate(
            SerieDetailsFragmentDirections.actionSerieDetailsFragmentToTournamentDetailsFragment(tournament)
        )
    }

    private fun onBackClick() {
        findNavController().popBackStack()
    }
}
