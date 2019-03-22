package br.com.paulosalvatore.pagseguroandroidturmab.api

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class GithubRepositoriesResult(
//    @SerializedName("items")
    @field:Json(name = "items")
    val repositories: List<Repository>
)

data class Repository(
    val id: Long?,
    val name: String?,
//    @SerializedName("full_name")
    @field:Json(name = "full_name")
    val fullName: String?,
    val description: String?,
    val owner: Owner?
)

data class Owner(
    val id: Long?,
    val login: String?,
//    @SerializedName("avatar_url")
    @field:Json(name = "avatar_url")
    val avatarUrl: String?
)
