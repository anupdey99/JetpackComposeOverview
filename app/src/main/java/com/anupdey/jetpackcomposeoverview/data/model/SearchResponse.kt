package com.anupdey.jetpackcomposeoverview.data.model


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("items")
    val items: List<RepoInfo>
)