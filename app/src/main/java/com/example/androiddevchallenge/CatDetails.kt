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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun CatDetailScreen(
    navController: NavController,
    catId: Int
) {
    val cat = CatDataGenerator.catData[catId]
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.greetings, cat?.givenName.orEmpty())) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        cat?.let { catNotNull ->
            CatDetailsContent(catNotNull)
        }
    }
}

@Preview
@Composable
private fun CatDetailsContent(
    @PreviewParameter(CatPreviewDataProvider::class, 1) cat: Cat
) {
    val scrollState = rememberScrollState()
    Column(
        Modifier.verticalScroll(scrollState)
    ) {
        Box(
            Modifier
                .height(240.dp)
                .fillMaxWidth()
        ) {
            CoilImage(
                data = cat.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Column {
            TextLabelRow(
                stringResource(id = R.string.name),
                cat.givenName,
                false
            )
            TextLabelRow(
                stringResource(id = R.string.gender),
                if (cat.sex == Sex.MALE) {
                    stringResource(id = R.string.gender_male)
                } else {
                    stringResource(id = R.string.gender_female)
                },
                true
            )
            TextLabelRow(
                stringResource(id = R.string.breed),
                cat.breed.asBreedName(),
                false
            )
            TextLabelRow(
                stringResource(id = R.string.weight),
                cat.weight,
                true
            )
            TextLabelRow(
                stringResource(id = R.string.date_of_birth),
                Utils.asReadableDate(cat.birthdate),
                false
            )
            TextLabelRow(
                "",
                "(${stringResource(id = R.string.age)} ${cat.age})",
                false
            )
            TextLabelRow(
                stringResource(id = R.string.waiting_for_adaption_since),
                Utils.asReadableDate(cat.waitingForAdoptionSince),
                true
            )
            TextLabelRow(
                stringResource(id = R.string.favorite_food),
                cat.favoriteFood,
                false
            )
        }
    }
}

@Composable
private fun TextLabelRow(label: String, content: String, highLightBackground: Boolean) {
    Row(
        modifier = Modifier
            .background(
                if (highLightBackground) {
                    MaterialTheme.colors.secondary
                } else {
                    MaterialTheme.colors.background
                }
            )
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Text(modifier = Modifier.weight(2f), text = label)
        Text(text = content)
    }
}
