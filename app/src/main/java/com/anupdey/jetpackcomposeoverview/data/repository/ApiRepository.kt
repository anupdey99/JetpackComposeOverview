package com.anupdey.jetpackcomposeoverview.data.repository

import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo

interface ApiRepository {

    suspend fun searchRepositories(): List<RepoInfo>

}