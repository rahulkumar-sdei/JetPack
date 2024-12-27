package com.org.jet.domain.repository

import com.org.jet.data.dto.MuseumObjectDto
import com.org.jet.screens.seemeHome.ProductRes

interface MuseumRepository {
    suspend fun getData(): List<MuseumObjectDto>
    suspend fun getProducts(): ProductRes?
}