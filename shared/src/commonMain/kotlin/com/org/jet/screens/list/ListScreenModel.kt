package com.org.jet.screens.list

import cafe.adriel.voyager.core.model.ScreenModel
import com.org.jet.domain.model.MuseumObject
import com.org.seemekmm.domain.usecase.GetMuseumList
import kotlinx.coroutines.flow.Flow

class ListScreenModel(museumRepository: GetMuseumList) : ScreenModel {
    val objects: Flow<List<MuseumObject>> =  museumRepository()
//        museumRepository().stateIn(CoroutineScope(Dispatchers.Main + SupervisorJob() ), SharingStarted.WhileSubscribed(5000), emptyList())

}
