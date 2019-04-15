package br.com.paulosalvatore.pagseguroandroidturmab

import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

class Application @Inject constructor(
    val okHttp: OkHttp,
    val twitterApi: TwitterApi
)

class MainKt {

    @Inject
    lateinit var okHttp: OkHttp

    @Inject
    lateinit var twitterApi: TwitterApi

    fun main() {


        val user = "Paulo Salvatore"
//        val okHttp = OkHttp()
//        val twitterApi = TwitterApi(user, okHttp)

        val tweeter = Tweeter(user, twitterApi)
        tweeter.tweet("Tweet 1")
        tweeter.tweet("Tweet 2")

        val timeline = Timeline(user, twitterApi)
        timeline.get()
    }
}

class Tweeter(val user: String, val twitterApi: TwitterApi) {
    fun tweet(text: String) {
        twitterApi.tweet("Texto para twittar")
    }
}

class Timeline(val user: String, val twitterApi: TwitterApi) {
    fun get() {
        twitterApi.timeline()
    }
}

@Singleton
class TwitterApi @Inject constructor(val okHttp: OkHttp) {

    fun tweet(text: String) {
        okHttp.post("realizar tweet")
    }

    fun timeline() {
        okHttp.post("obter timeline")
    }
}

@Singleton
class OkHttp @Inject constructor() {
    fun post(action: String) {
    }
}

@Module
class NetworkModule {

}

@Module
class TwitterModule(private val user: String) {

}

@Component(
    modules = [
        NetworkModule::class,
        TwitterModule::class
    ]
)
interface TwitterComponent
