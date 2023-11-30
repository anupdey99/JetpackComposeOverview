package com.anupdey.jetpackcomposeoverview.di.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.anupdey.jetpackcomposeoverview.data.repository.ApiRepository
import com.anupdey.jetpackcomposeoverview.data.repository.ApiRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindApiRepository(repository: ApiRepositoryImpl): ApiRepository

}