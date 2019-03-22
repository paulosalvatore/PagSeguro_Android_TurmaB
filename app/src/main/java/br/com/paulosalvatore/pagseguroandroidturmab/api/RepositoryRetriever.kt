package br.com.paulosalvatore.pagseguroandroidturmab.api

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RepositoryRetriever {
    private val service: GithubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GithubService::class.java)
    }

    fun getLanguageRepositories(
        language: String,
        callback: Callback<GithubRepositoriesResult>
    ) {
        val call = service.searchRepositories("language:$language")
        call.enqueue(callback)
    }
}
