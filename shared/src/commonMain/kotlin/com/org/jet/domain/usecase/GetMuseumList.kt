package com.org.seemekmm.domain.usecase

import com.org.jet.domain.model.MuseumObject
import com.org.jet.domain.repository.MuseumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMuseumList(private val museumRepository: MuseumRepository) {

    operator fun invoke(): Flow<List<MuseumObject>> {
        return flow {
            emit(museumRepository.getData().map {
                println("GetMuseumList.invoke ${it.toString()}")
                it.toMuseumObject() })
        }
    }
}