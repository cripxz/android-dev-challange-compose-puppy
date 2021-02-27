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

import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

data class Cat(
    val id: Int,
    val breed: CatBreed,
    val givenName: String,
    val birthdate: Date,
    val imageUrl: String,
    val weight: String,
    val favoriteFood: String,
    val waitingForAdoptionSince: Date,
    val sex: Sex
) {
    val age: String = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - birthdate.time).toInt().let { timeInDays ->
        when {
            timeInDays < 60 -> "$timeInDays Days"
            timeInDays < 731 -> String.format("%d months", timeInDays / 30)
            else -> String.format("%d years", timeInDays / 365)
        }
    }
}

enum class CatBreed {
    ABYSSINIAN,
    AMERICAN_BOBTAIL,
    AMERICAN_CURL,
    AMERICAN_SHORTHAIR,
    AMERICAN_WIREHAIR,
    BALINESE,
    BENGAL,
    BIRMAN,
    BOMBAY,
    BRITISH_SHORTHAIR,
    BURMESE,
    CHARTREUX,
    CHAUSIE,
    COLORPOINT_SHORTHAIR,
    CORNISH_REX,
    DEVON_REX,
    DOMESTIC_SHORT_HAIR,
    EGYPTIAN_MAU,
    EUROPEAN_BURMESE,
    EXOTIC,
    HAVANA_BROWN,
    HIGHLANDER,
    HIMALAYAN,
    JAPANESE_BOBTAIL,
    JAVANESE,
    KORAT,
    KURILIAN_BOBTAIL,
    LA_PERM,
    MAINE_COON,
    MANX,
    MUNCHKIN,
    NORWEGIAN_FOREST,
    OCICAT,
    ORIENTAL,
    ORIENTAL_LONGHAIR,
    PERSIAN,
    PETERBALD,
    PIXIEBOB,
    RAGAMUFFIN,
    RAGDOLL,
    RUSSIAN_BLUE,
    SAVANNAH,
    SCOTTISH_FOLD,
    SELKIRK_REX,
    SIAMESE,
    SIBERIAN,
    SINGAPURA,
    SNOWSHOE,
    SOMALI,
    SPHYNX,
    THAI,
    TONKINESE,
    TOYGER,
    TURKISH_ANGORA,
    TURKISH_VAN;

    fun asBreedName() = this.name.replace("_", " ").toLowerCase(Locale.getDefault())
}

enum class Sex {
    MALE,
    FEMALE
}
