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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.info)) },
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
        InfoScreenContent()
    }
}

@Composable
private fun InfoScreenContent() {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = stringResource(id = R.string.info_text_intro), style = TextStyle(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.info_text_sources), style = TextStyle(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.info_text_source_images))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = stringResource(id = R.string.info_text_source_images_url))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.info_text_source_cat_breeds))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = stringResource(id = R.string.info_text_source_cat_breeds_url))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.info_text_source_cat_names))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = stringResource(id = R.string.info_text_source_cat_names_url))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.info_text_other_libraries), style = TextStyle(fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.info_text_other_libraries_coil))
    }
}
