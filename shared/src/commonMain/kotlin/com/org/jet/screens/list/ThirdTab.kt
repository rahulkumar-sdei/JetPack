package com.org.jet.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

object ThirdTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "ThirdTab"
            val icon = rememberVectorPainter(Icons.Default.AccountBox)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val screenModel: ListScreenModel = getScreenModel()
        val list by screenModel.objects.collectAsState(initial = null)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            LazyColumn {
                if (list.isNullOrEmpty()){
                    item {
                        Box {
                            Text(
                                text = "No Data found",
                                modifier = Modifier.padding(16.dp),
                                fontSize = 16.sp
                            )
                        }
                    }

                }else {
                    items(list?.size ?: 0) {
                        val obj = list?.get(it)
                        Card(
                            Modifier.padding(vertical = 8.dp),
                            shape = RoundedCornerShape(10.dp),
                            elevation = 4.dp,
                            backgroundColor = Color.White
                        ) {
                            Column(
                                Modifier
                                    .clickable {  }
                            ) {
                                KamelImage(
                                    resource = asyncPainterResource(data = obj?.primaryImageSmall?:"NA"),
                                    contentDescription = obj?.title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .aspectRatio(1f)
                                        .background(Color.LightGray),
                                )

                                Spacer(Modifier.height(2.dp))
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(
                                        obj?.title?:"NA",
                                        style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold, color = Color.White),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        obj?.artistDisplayName?:"NA", style = MaterialTheme.typography.body2.copy(color = Color.White),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        obj?.objectDate?:"NA", style = MaterialTheme.typography.caption.copy(color = Color.White),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}