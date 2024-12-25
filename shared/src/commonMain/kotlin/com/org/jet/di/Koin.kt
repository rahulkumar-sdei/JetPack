package com.org.jet.di

import com.org.jet.data.InMemoryMuseumStorage
import com.org.jet.data.MuseumStorage
import com.org.jet.data.repository.MuseumRepositoryImpl
import com.org.jet.domain.repository.MuseumRepository
import com.org.seemekmm.domain.usecase.GetMuseumById
import com.org.seemekmm.domain.usecase.GetMuseumList
import com.org.jet.screens.detail.DetailScreenModel
import com.org.jet.screens.list.ListScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
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
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }
            install(Logging) {
            }
        }
    }

    single<MuseumRepository> { MuseumRepositoryImpl(get()) }
    single<MuseumStorage> { InMemoryMuseumStorage() }
    single {
        GetMuseumById(get())
        GetMuseumList(get())
    }
}

val screenModelsModule = module {
    factoryOf(::ListScreenModel)
    factory {
        DetailScreenModel(GetMuseumById(get()))
    }
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            screenModelsModule,
        )
    }
}
