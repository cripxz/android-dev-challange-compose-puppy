/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.coil.CoilImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CatListScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("info")
                        }
                    ) {
                        Icon(
                            Icons.Filled.Info,
                            "info"
                        )
                    }
                }
            )
        },
    ) {
        val data = CatDataGenerator.catData
        val scrollState = rememberLazyListState()
        LazyVerticalGrid(state = scrollState, cells = GridCells.Fixed(2)) {
            items(data.entries.size) {
                data[it]?.let { cat ->
                    CatListItem(cat = cat) { catId ->
                        navController.navigate("catDetails?catId=$catId")
                    }
                }
            }
        }
    }
}

@Composable
private fun CatListItem(
    @PreviewParameter(CatPreviewDataProvider::class, 1) cat: Cat,
    onCardClicked: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onCardClicked(cat.id)
            },
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            CoilImage(
                modifier = Modifier
                    .aspectRatio(1.33f),
                data = cat.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp),
                        )
                    }
                }
            )
            Text(
                text = "${cat.givenName} (${cat.age})",
                modifier = Modifier.padding(8.dp),
                fontSize = 16.sp
            )
        }
    }
}
