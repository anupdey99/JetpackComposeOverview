package com.anupdey.jetpackcomposeoverview.ui.common

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo
import com.anupdey.jetpackcomposeoverview.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {

    private val _repoList = MutableLiveData<List<RepoInfo>>()
    val repoList: LiveData<List<RepoInfo>> = _repoList

    private val _repoListState: MutableState<List<RepoInfo>> = mutableStateOf(emptyList())
    val repoListState: State<List<RepoInfo>> = _repoListState

    init {
        searchRepositories()
    }

    private fun searchRepositories() {
        viewModelScope.launch {
            val response = repository.searchRepositories()
            _repoList.value = response
            _repoListState.value = response
        }
    }

    fun fetchByRepoId(id: Int?): RepoInfo? {
        return _repoList.value?.find { it.id == id }
    }

}