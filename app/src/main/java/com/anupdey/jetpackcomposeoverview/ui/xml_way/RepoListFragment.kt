package com.anupdey.jetpackcomposeoverview.ui.xml_way

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.anupdey.jetpackcomposeoverview.databinding.FragmentRepoListBinding
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoListFragment : Fragment() {

    private var _binding: FragmentRepoListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private val dataAdapter = DataAdapter()

    companion object {
        fun newInstance(): RepoListFragment {
            return RepoListFragment()
        }

        val tag: String = RepoListFragment::class.java.name
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRepoListBinding.inflate(layoutInflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        searchRepo()
        initListener()
    }

    private fun initList() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dataAdapter
        }
    }

    private fun searchRepo() {
        viewModel.repoList.observe(viewLifecycleOwner) { list ->
            dataAdapter.initList(list)
        }
    }

    private fun initListener() {
        dataAdapter.setListener { id ->
            goToDetails(id)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun goToDetails(id: Int) {
        (activity as? RepoSearchActivity)?.goToRepoDetailsFragment(id)
    }

}