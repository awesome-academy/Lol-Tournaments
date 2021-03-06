package com.sunasterisk.loltournaments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.lang.IllegalStateException

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    protected abstract val layoutResource: Int
    abstract val viewModel: BaseViewModel?

    private var _binding: T? = null
    protected val binding: T get() = _binding!! ?: throw IllegalStateException(ERROR_VIEW_DATA_BINDING)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<T>(inflater, layoutResource, container, false)
        .apply { _binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
        initActions()
    }

    protected abstract fun initViews()
    protected abstract fun initData()
    protected abstract fun initActions()

    companion object {
        const val ERROR_VIEW_DATA_BINDING = "ViewDataBinding is null."
    }
}
