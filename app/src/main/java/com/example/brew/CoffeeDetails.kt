package com.example.brew

import androidx.annotation.DrawableRes

data class CoffeeDetails(
    val id: Int,
    val origin: String,
    val instructions: List<String>,
    @DrawableRes val imageCarousel: List<Int>
)

val coffeeDetails = listOf(
    // espresso
    CoffeeDetails(
        id = 1,
        origin = "Italy",
        instructions = listOf(
            "1. Finely grind high-quality coffee beans.",
            "2. Fill and tamp the portafilter firmly.",
            "3. Lock it into the espresso machine.",
            "4. Brew using 9 bars of pressure for 25-30 seconds.",
            "5. Serve immediately in a demitasse cup."
        ),
        imageCarousel = listOf(
            R.drawable.espresso_1,
            R.drawable.espresso_2,
            R.drawable.espresso_3,
            R.drawable.espresso_4,
            R.drawable.espresso_5
        )
    ),
    // americano
    CoffeeDetails(
        id = 2,
        origin = "United States",
        instructions = listOf(
            "1. Brew a standard espresso shot.",
            "2. Heat fresh water to near boiling.",
            "3. Pour hot water over the espresso.",
            "4. Use a 1:1 or 1:2 espresso-to-water ratio.",
            "5. Serve in a medium cup."
        ),
        imageCarousel = listOf(
            R.drawable.americano_1,
            R.drawable.americano_2,
            R.drawable.americano_3,
            R.drawable.americano_4,
            R.drawable.americano_5
        )
    ),
    // latte
    CoffeeDetails(
        id = 3,
        origin = "Italy",
        instructions = listOf(
            "1. Pull a fresh shot of espresso.",
            "2. Steam milk until it's smooth and slightly frothy.",
            "3. Pour steamed milk into the espresso slowly.",
            "4. Aim for 1:3 espresso-to-milk ratio.",
            "5. Top with light foam or latte art (optional)."
        ),
        imageCarousel = listOf(
            R.drawable.latte_1,
            R.drawable.latte_2,
            R.drawable.latte_3,
            R.drawable.latte_4,
            R.drawable.latte_5
        )
    ),
    //cappucino
    CoffeeDetails(
        id = 4,
        origin = "Italy",
        instructions = listOf(
            "1. Brew a strong espresso shot.",
            "2. Steam milk to create a thick foam.",
            "3. Pour steamed milk over the espresso.",
            "4. Top with equal parts milk and foam.",
            "5. Dust with cocoa or cinnamon (optional)."
        ),
        imageCarousel = listOf(
            R.drawable.cap_1,
            R.drawable.cap_2,
            R.drawable.cap_3,
            R.drawable.cap_4,
            R.drawable.cap_5
        )
    ),
    // flat white
    CoffeeDetails(
        id = 5,
        origin = "Australia/New Zealand",
        instructions = listOf(
            "1. Prepare a double shot of espresso.",
            "2. Steam milk to a silky microfoam texture.",
            "3. Swirl and pour the milk over the espresso.",
            "4. Keep milk-to-foam ratio lower than a latte.",
            "5. Serve in a small cup."
        ),
        imageCarousel = listOf(
            R.drawable.flat_1,
            R.drawable.flat_2,
            R.drawable.flat_3,
            R.drawable.flat_4,
            R.drawable.flat_5
        )
    )
)