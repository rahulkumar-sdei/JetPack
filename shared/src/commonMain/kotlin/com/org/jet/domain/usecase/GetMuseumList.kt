package com.org.jet.domain.usecase

import com.org.jet.domain.model.MuseumObject
import com.org.jet.domain.repository.MuseumRepository
import com.org.jet.screens.seemeHome.ProductRes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMuseumList(private val museumRepository: MuseumRepository) {

    operator fun invoke(): Flow<List<MuseumObject>> {
        return flow {
            emit(museumRepository.getData().map {
                println("GetMuseumList.invoke $it")
                it.toMuseumObject() })
        }
    }
}
class GetProductList(private val museumRepository: MuseumRepository) {

    operator fun invoke(): Flow<ProductRes?> {
        return flow {
            emit(museumRepository.getProducts())
        }
    }
}