package com.sunasterisk.loltournaments.ui.more

import android.app.Dialog
import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.sunasterisk.loltournaments.R
import com.sunasterisk.loltournaments.base.BaseFragment
import com.sunasterisk.loltournaments.base.BaseViewModel
import com.sunasterisk.loltournaments.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment<FragmentMoreBinding>() {
    override val layoutResource get() = R.layout.fragment_more
    override val viewModel: BaseViewModel?
        get() = null

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initActions() {
        binding.apply {
            cardAboutApp.setOnClickListener { openAboutAppDialog() }
            cardShare.setOnClickListener { shareApp() }
        }
    }

    private fun openAboutAppDialog() {
        activity?.let {
            Dialog(it).apply {
                setContentView(R.layout.fragment_about_app)
                show()
            }
        }
    }

    private fun shareApp() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, getString(R.string.link_app))
        }
        startActivity(intent)
    }
}
