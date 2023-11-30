package com.anupdey.jetpackcomposeoverview.data.repository

import com.anupdey.jetpackcomposeoverview.data.endpoint.ApiInterface
import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo
import java.util.concurrent.CancellationException
import javax.inject.Inject

class ApiRepositoryImpl
@Inject constructor(
    private val apiInterface: ApiInterface
) : ApiRepository {

    override suspend fun searchRepositories(): List<RepoInfo> {
        return try {
            val response = apiInterface.searchRepositories()
            response.items
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            emptyList()
        }
    }

}