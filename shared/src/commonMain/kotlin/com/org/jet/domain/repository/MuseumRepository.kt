package com.org.jet.domain.repository

import com.org.jet.data.dto.MuseumObjectDto

interface MuseumRepository {
    suspend fun getData(): List<MuseumObjectDto>
}