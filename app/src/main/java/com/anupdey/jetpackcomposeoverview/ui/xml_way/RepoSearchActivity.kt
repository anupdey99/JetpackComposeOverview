package com.anupdey.jetpackcomposeoverview.ui.xml_way

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.anupdey.jetpackcomposeoverview.R
import com.anupdey.jetpackcomposeoverview.databinding.ActivityRepoSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        loadFragment()
    }

    private fun setToolbar() {
        binding.appToolbar.toolbarTitle.text = getString(R.string.top_android_repos)
        binding.appToolbar.toolbarBtn.apply {
            isVisible = true
            setOnClickListener {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish()
                }
            }
        }
    }

    private fun loadFragment() {
        val fragment = RepoListFragment.newInstance()
        val tag = RepoListFragment.tag

        supportFragmentManager.beginTransaction().apply {
            replace(binding.container.id, fragment, tag)
            commit()
        }
    }

    fun goToRepoDetailsFragment(id: Int) {
        val fragment = RepoDetailsFragment.newInstance(id)
        val tag = RepoDetailsFragment.tag

        supportFragmentManager.beginTransaction().apply {
            add(binding.container.id, fragment, tag)
            addToBackStack(tag)
            commit()
        }
    }

}