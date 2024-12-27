package com.org.jet.screens.list

import cafe.adriel.voyager.core.model.ScreenModel
import com.org.jet.domain.model.MuseumObject
import com.org.jet.domain.usecase.GetMuseumList
import com.org.jet.domain.usecase.GetProductList
import com.org.jet.screens.seemeHome.ProductRes
import kotlinx.coroutines.flow.Flow

class HomeScreenModel(productRepo: GetProductList) : ScreenModel {
    val objects: Flow<ProductRes?> =  productRepo()

}
