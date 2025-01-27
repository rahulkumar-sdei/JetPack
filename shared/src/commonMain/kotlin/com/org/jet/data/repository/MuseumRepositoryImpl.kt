package com.org.jet.data.repository

import com.org.jet.data.dto.MuseumObjectDto
import com.org.jet.domain.repository.MuseumRepository
import com.org.jet.screens.seemeHome.ProductRes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.coroutines.cancellation.CancellationException

class MuseumRepositoryImpl(private val client: HttpClient) : MuseumRepository {
    companion object {
        private const val API_URL =
            "https://raw.githubusercontent.com/Kotlin/KMP-App-Template/main/list.json"
        private const val PRODUCTS_URL =
            "https://dummyjson.com/products"
    }

    override suspend fun getData(): List<MuseumObjectDto> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
    }

    override suspend fun getProducts(): ProductRes? {
        return try {
            client.get(PRODUCTS_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            null
        }
    }
}