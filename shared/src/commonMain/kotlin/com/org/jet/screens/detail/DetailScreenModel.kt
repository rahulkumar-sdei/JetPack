package com.org.jet.screens.detail

import cafe.adriel.voyager.core.model.ScreenModel
import com.org.jet.domain.model.MuseumObject
import com.org.jet.domain.usecase.GetMuseumById
import kotlinx.coroutines.flow.Flow

class DetailScreenModel(private val getDetails: GetMuseumById) : ScreenModel {
    fun getObject(objectId: Int): Flow<MuseumObject?> = getDetails(objectId)
}
