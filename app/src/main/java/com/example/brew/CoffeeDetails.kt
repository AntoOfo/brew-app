package com.example.brew

import androidx.annotation.DrawableRes

data class CoffeeDetails(
    val id: Int,
    val origin: String,
    val type: String,
    val instructions: List<String>,
    @DrawableRes val imageCarousel: List<Int>
)

val coffeeDetails = listOf(
    // espresso
    CoffeeDetails(
        id = 1,
        origin = "Italy",
        type = "Espresso",
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
        type = "Americano",
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
        type = "Latte",
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
        type = "Cappuccino",
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
        type = "Flat White",
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
    ),
    // mocha
    CoffeeDetails(
        id = 6,
        origin = "Yemen",
        type = "Mocha",
        instructions = listOf(
            "1. Brew a shot of espresso.",
            "2. Mix with 1-2 tsp of chocolate syrup or cocoa.",
            "3. Steam milk and pour it over the mix.",
            "4. Stir gently to blend flavours.",
            "5. Top with whipped cream or chocolate shavings."
        ),
        imageCarousel = listOf(
            R.drawable.mocha_1,
            R.drawable.mocha_2,
            R.drawable.mocha_3,
            R.drawable.mocha_4,
            R.drawable.mocha_5
        )
    ),
    // macchiato
    CoffeeDetails(
        id = 7,
        origin = "Italy",
        type = "Macchiato",
        instructions = listOf(
            "1. Pull a single or double shot of espresso.",
            "2. Steam a small amount of milk.",
            "3. Spoon a small amount of foam onto the espresso.",
            "4. Serve in a small glass or cup.",
            "5. Add caramel for a sweeter taste (optional)."
        ),
        imageCarousel = listOf(
            R.drawable.macc_1,
            R.drawable.macc_2,
            R.drawable.macc_3,
            R.drawable.macc_4,
            R.drawable.macc_5
        )
    ),
    // cold brew
    CoffeeDetails(
        id = 8,
        origin = "Japan",
        type = "Cold Brew",
        instructions = listOf(
            "1. Coarsely grind coffee beans.",
            "2. Combine coffee and cold water in a jar (1:8 ratio).",
            "3. Place in a fridge for 12-24 hours.",
            "4. Strain through a fine filter.",
            "5. Serve over ice, optionally with milk or syrup."
        ),
        imageCarousel = listOf(
            R.drawable.cold_1,
            R.drawable.cold_2,
            R.drawable.cold_3,
            R.drawable.cold_4,
            R.drawable.cold_5
        )
    ),
    // long black
    CoffeeDetails(
        id = 9,
        origin = "Australia/New Zealand",
        type = "Long Black",
        instructions = listOf(
            "1. Heat water to just below boiling.",
            "2. Pour hot water into a cup (about 2/3 full).",
            "3. Pull a double shot of espresso.",
            "4. Pour espresso gently over the hot water.",
            "5. Serve immediately with crema preserved."
        ),
        imageCarousel = listOf(
            R.drawable.long_1,
            R.drawable.long_2,
            R.drawable.long_3,
            R.drawable.long_4,
            R.drawable.long_5
        )
    ),
    // turkish coffee
    CoffeeDetails(
        id = 10,
        origin = "Turkey",
        type = "Turkish Coffee",
        instructions = listOf(
            "1. Finely grind coffee beans to a powder.",
            "2. Mix coffee, water, and sugar in a cezve.",
            "3. Heat slowly until foam forms, don't boil.",
            "4. Pour foam into a cup, return to heat briefly.",
            "5. Pour rest of coffee and let grounds settle before drinking."
        ),
        imageCarousel = listOf(
            R.drawable.turk_1,
            R.drawable.turk_2,
            R.drawable.turk_3,
            R.drawable.turk_4,
            R.drawable.turk_5
        )
    ),
    // ristretto
    CoffeeDetails(
        id = 11,
        origin = "Italy",
        type = "Ristretto",
        instructions = listOf(
            "1. Use a fine grind of dark roasted coffee beans.",
            "2. Tamp firmly into the portafilter.",
            "3. Extract a short shot (15-20ml) of espresso.",
            "4. Stop extraction early for concentrated flavour.",
            "5. Serve in a demitasse cup immediately."
        ),
        imageCarousel = listOf(
            R.drawable.ristretto_1,
            R.drawable.ristretto_2,
            R.drawable.ristretto_3,
            R.drawable.ristretto_4,
            R.drawable.ristretto_5
        )
    ),
    // affogato
    CoffeeDetails(
        id = 12,
        origin = "Italy",
        type = "Affogato",
        instructions = listOf(
            "1. Scoop quality vanilla ice cream into a small bowl.",
            "2. Brew a single shot of hot espresso.",
            "3. Pour espresso directly over the ice cream.",
            "4. Let it slightly melt for a cream contrast.",
            "5. Enjoy quickly before it fully melts."
        ),
        imageCarousel = listOf(
            R.drawable.affogato_1,
            R.drawable.affogato_2,
            R.drawable.affogato_3,
            R.drawable.affogato_4,
            R.drawable.affogato_5
        )
    ),
    // cortado
    CoffeeDetails(
        id = 13,
        origin = "Spain",
        type = "Cortado",
        instructions = listOf(
            "1. Brew a shot of espresso.",
            "2. Steam milk to around 60°C (140°F), without frothing.",
            "3. Pour equal parts steamed milk into the espresso.",
            "4. Gently mix for a smooth, balanced taste.",
            "5. Serve in a small glass."
        ),
        imageCarousel = listOf(
            R.drawable.cortado_1,
            R.drawable.cortado_2,
            R.drawable.cortado_3,
            R.drawable.cortado_4,
            R.drawable.cordato_5
        )
    ),
    // red eye
    CoffeeDetails(
        id = 14,
        origin = "United States",
        type = "Red Eye",
        instructions = listOf(
            "1. Brew a fresh cup of drip coffee.",
            "2. Prepare a single shot of espresso.",
            "3. Pour the espresso into the drip coffee.",
            "4. Stir gently for an even blend.",
            "5. Serve hot and strong."
        ),
        imageCarousel = listOf(
            R.drawable.redeye_1,
            R.drawable.redeye_2,
            R.drawable.redeye_3,
            R.drawable.redeye_4,
            R.drawable.redeye_5
        )
    )
)