package com.anupdey.jetpackcomposeoverview.ui.xml_way

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.anupdey.jetpackcomposeoverview.databinding.FragmentRepoDetailsBinding
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailsFragment : Fragment() {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    companion object {
        fun newInstance(id: Int): RepoDetailsFragment {
            return RepoDetailsFragment().apply {
                arguments = bundleOf(
                    "id" to id
                )
            }
        }

        val tag: String = RepoDetailsFragment::class.java.name
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentRepoDetailsBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id") ?: -1
        if (id == -1) return

        val model = viewModel.fetchByRepoId(id) ?: return

        Glide.with(binding.ivAvatar)
            .load(model.owner?.avatarUrl)
            .into(binding.ivAvatar)

        binding.repoName.text = model.name
        binding.repoUrl.text = model.htmlUrl
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}