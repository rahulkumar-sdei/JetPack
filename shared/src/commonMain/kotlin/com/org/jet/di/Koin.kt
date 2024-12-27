package com.org.jet.di

import com.org.jet.data.InMemoryMuseumStorage
import com.org.jet.data.MuseumStorage
import com.org.jet.data.repository.MuseumRepositoryImpl
import com.org.jet.domain.repository.MuseumRepository
import com.org.jet.domain.usecase.GetMuseumById
import com.org.jet.domain.usecase.GetMuseumList
import com.org.jet.domain.usecase.GetProductList
import com.org.jet.screens.detail.DetailScreenModel
import com.org.jet.screens.list.HomeScreenModel
import com.org.jet.screens.list.ListScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
            install(Logging) {
                logger = object : io.ktor.client.plugins.logging.Logger {
                    override fun log(message: String) {
                        println("Ktor Log: $message")
                    }
                }
                level = io.ktor.client.plugins.logging.LogLevel.BODY
            }

        }
    }

    single<MuseumRepository> { MuseumRepositoryImpl(get()) }
    single<MuseumStorage> { InMemoryMuseumStorage() }
    single {
        GetMuseumById(get())
        GetMuseumList(get())
    }
    single {
        GetProductList(get())
    }
}

val screenModelsModule = module {
    factoryOf(::ListScreenModel)
    factory {
        DetailScreenModel(GetMuseumById(get()))
    }
    factoryOf(::HomeScreenModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            screenModelsModule,
        )
    }
}
