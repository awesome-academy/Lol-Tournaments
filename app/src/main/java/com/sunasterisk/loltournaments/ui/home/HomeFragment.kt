package com.sunasterisk.loltournaments.ui.home

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.data.source.remote.*
import com.sunasterisk.loltournaments.databinding.FragmentHomeBinding
import com.sunasterisk.loltournaments.ui.adapter.LeagueAdapter
import com.sunasterisk.loltournaments.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutResource = R.layout.fragment_home
    override val viewModel by sharedViewModel<HomeViewModel>()

    private val fragmentSerieCompleted = SerieCompletedFragment()
    private val fragmentSerieRunning = SerieRunningFragment()
    private val fragmentSerieUpcoming = SerieUpcomingFragment()
    private val leagueAdapter by lazy { context?.let { LeagueAdapter(it) } }
    private val leagueIds = listOf(
        LCK_LEAGUE_ID,
        LPL_LEAGUE_ID,
        WORLD_LEAGUE_ID,
        MSI_LEAGUE_ID,
        VCS_LEAGUE_ID,
        LEC_LEAGUE_ID,
        LCS_LEAGUE_ID
    )

    override fun initViews() {
        initSpinnerLeague()
        initTabLayoutWithViewPager()
    }

    override fun initData() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            homeViewModel = viewModel
        }
        viewModel.getLeagues(leagueIds, QUERY_VALUE_ID)
    }

    override fun initActions() {
        binding.spinnerLeague.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.setCurrentLeagueId(leagueIds[position])
            }
        }

        viewModel.leagues.observe(viewLifecycleOwner, Observer {
            if (spinnerLeague.count != it.size) leagueAdapter?.setData(it)
        })
    }

    private fun initTabLayoutWithViewPager() {
        val homeViewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        homeViewPagerAdapter.addFragment(fragmentSerieCompleted, getString(R.string.title_completed))
        homeViewPagerAdapter.addFragment(fragmentSerieRunning, getString(R.string.title_running))
        homeViewPagerAdapter.addFragment(fragmentSerieUpcoming, getString(R.string.title_upcoming))

        pagerSeries.adapter = homeViewPagerAdapter
        tabSeries.setupWithViewPager(pagerSeries)
    }

    private fun initSpinnerLeague() {
        binding.spinnerLeague.adapter = leagueAdapter
    }
}
