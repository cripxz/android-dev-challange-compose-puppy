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
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import kotlin.random.Random

object CatDataGenerator {

    private val catFood: List<String> = listOf(
        "fish",
        "cat food",
        "dry cat food",
        "meat",
        "ham",
        "grass",
        "spiders",
        "milk",
        "dog food",
        "cheese",
        "lasagna",
        "noodles",
        "beef",
        "pork",
        "tuna"
    )

    private val catNames = listOf(
        "Oliver",
        "Leo",
        "Milo",
        "Charlie",
        "Simba",
        "Max",
        "Jack",
        "Loki",
        "Tiger",
        "Jasper",
        "Ollie",
        "Oscar",
        "George",
        "Buddy",
        "Toby",
        "Smokey",
        "Finn",
        "Felix",
        "Simon",
        "Shadow",
        "Louie",
        "Salem",
        "Binx",
        "Dexter",
        "Gus",
        "Oreo",
        "Henry",
        "Winston",
        "Tigger",
        "Kitty",
        "Gizmo",
        "Apollo",
        "Theo",
        "Rocky",
        "Sam",
        "Sammy",
        "Jax",
        "Teddy",
        "Sebastian",
        "Bandit",
        "Boots",
        "Thor",
        "Bear",
        "Zeus",
        "Chester",
        "Prince",
        "Pumpkin",
        "Tucker",
        "Cooper",
        "Blue",
        "Ziggy",
        "Frankie",
        "Frank",
        "Romeo",
        "Cosmo",
        "Archie",
        "Lucky",
        "Benny",
        "Joey",
        "Kevin",
        "Midnight",
        "Merlin",
        "Casper",
        "Tom",
        "Ash",
        "Goose",
        "Murphy",
        "Bob",
        "Boo",
        "Moose",
        "Jackson",
        "Marley",
        "Calvin",
        "Garfield",
        "Bruce",
        "Ozzy",
        "Maverick",
        "Thomas",
        "Tommy",
        "Mac",
        "Bubba",
        "Fred",
        "Sunny",
        "Pepper",
        "Peanut",
        "Louis",
        "Otis",
        "Hunter",
        "Buster",
        "Walter",
        "Mickey",
        "Percy",
        "Harley",
        "Clyde",
        "Mango",
        "Bentley",
        "Jinx",
        "Hobbes",
        "Bean",
        "Bagheera"
    )

    val catData: Map<Int, Cat> = generateCatData()

    private fun generateCatData(): Map<Int, Cat> {
        return (0..50).map { id ->
            val birthDate = getRandomDate(
                from = Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(365 * 4)),
                to = Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(20))
            )
            id to Cat(
                id,
                CatBreed.values().random(),
                getRandomCatName(),
                birthDate,
                getRandomImageUrl(),
                getRandomWeight(),
                getRandomCatFood(),
                getRandomDate(
                    from = birthDate,
                    to = Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(20))
                ),
                Sex.values().random()
            )
        }.toMap()
    }

    private fun getRandomCatName(): String {
        return catNames.random()
    }

    private fun getRandomDate(from: Date, to: Date): Date {
        val random = ThreadLocalRandom.current().nextLong(from.time, to.time)
        return Date(random)
    }

    private fun getRandomWeight(): String = String.format("%.1f kg", Random.nextDouble(0.30, 5.00))

    private fun getRandomCatFood(): String = catFood.shuffled().take(3).joinToString(separator = ", ")

    private fun getRandomImageUrl(): String {
        val width = Random.nextInt(200, 400)
        val height = Random.nextInt(200, 400)
        return "https://placekitten.com/$width/$height"
    }
}
