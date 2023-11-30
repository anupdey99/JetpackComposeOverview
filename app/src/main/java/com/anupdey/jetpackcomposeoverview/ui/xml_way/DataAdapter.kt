package com.anupdey.jetpackcomposeoverview.ui.xml_way

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo
import com.anupdey.jetpackcomposeoverview.databinding.LayoutRepoItemBinding
import com.bumptech.glide.Glide

class DataAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: MutableList<RepoInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutRepoItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = dataList[position]
            holder.bind(model, position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initList(list: List<RepoInfo>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: LayoutRepoItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: RepoInfo, position: Int) {
            binding.repoName.text = model.name
            binding.repoOwner.text = model.owner?.login
            binding.repoUrl.text = model.htmlUrl
            binding.repoStar.text = model.stargazersCount.toString()

            Glide.with(binding.ivAvatar)
                .load(model.owner?.avatarUrl)
                .into(binding.ivAvatar)
        }
    }

}