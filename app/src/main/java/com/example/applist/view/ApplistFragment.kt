package com.example.applist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applist.R
import com.example.applist.adapter.ApplistAdapter
import com.example.applist.databinding.FragmentApplistBinding
import com.example.applist.viewModel.ApplistFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ApplistFragment : Fragment() {
    private val viewModel: ApplistFragmentViewModel by viewModels()
    private var  binding: FragmentApplistBinding? = null
    private lateinit var adapter : ApplistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentApplistBinding.bind(inflater.inflate(R.layout.fragment_applist, container, false))
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ApplistAdapter()
        binding?.rvAppList?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvAppList?.adapter = adapter

        lifecycleScope.launch {
            viewModel.apps.collect { appList ->
                adapter.submitList(appList)

            }
        }

    }

}