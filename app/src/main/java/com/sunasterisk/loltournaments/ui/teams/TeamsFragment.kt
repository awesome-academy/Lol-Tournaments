package com.sunasterisk.loltournaments.ui.teams

import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.model.remote.Team
import com.sunasterisk.loltournaments.databinding.FragmentTeamsBinding
import com.sunasterisk.loltournaments.ui.adapter.TeamAdapter
import com.sunasterisk.loltournaments.ultils.PaginationScrollListener
import com.sunasterisk.loltournaments.ultils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_teams.*
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
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
        initSearchListener()
        initRecyclerViewListener()
    }

    private fun initSearchListener() {
        binding.let {
            searchViewTeams.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    context?.let { context -> view?.hideKeyboard(context) }

                    query?.let {
                        viewModel.apply {
                            setTeamAcronym(it)
                            setSearchMode(true)
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrBlank()) {
                        viewModel.setSearchMode(false)
                    }
                    return true
                }
            })
        }
    }

    private fun initRecyclerViewListener() {
        binding.recyclerViewTeams.setOnScrollListener(object :
            PaginationScrollListener(recyclerViewTeams.layoutManager as LinearLayoutManager) {
            override fun onScrollLastItem() {
                viewModel.increaseCurrentPage()
            }

            override fun isScrolling(): Boolean {
                return viewModel.isLastPage.value == true
            }
        })
    }

    private fun onTeamClick(team: Team) {
        findNavController().navigate(
            TeamsFragmentDirections.actionTeamsFragmentToTeamDetailsFragment(team)
        )
    }
}
