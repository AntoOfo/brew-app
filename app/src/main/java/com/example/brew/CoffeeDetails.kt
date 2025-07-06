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
    ),
    // doppio
    CoffeeDetails(
        id = 15,
        origin = "Italy",
        type = "Doppio",
        instructions = listOf(
            "1. Use a double shot basket in your portafilter.",
            "2. Fill with finely ground coffee and tamp evenly.",
            "3. Extract about 60ml of espresso.",
            "4. Ensure it flows smoothly in 25-30 seconds.",
            "5. Serve immediately for a bold coffee hit."
        ),
        imageCarousel = listOf(
            R.drawable.doppio_1,
            R.drawable.doppio_2,
            R.drawable.doppio_3,
            R.drawable.doppio_4,
            R.drawable.doppio_5
        )
    ),
    // irish coffee
    CoffeeDetails(
        id = 16,
        origin = "Ireland",
        type = "Irish Coffee",
        instructions = listOf(
            "1. Brew a strong hot coffee.",
            "2. Add 1 tsp brown sugar and stir to dissolve.",
            "3. Pour in 1 shot of Irish whiskey.",
            "4. Lightly whip cream until thick but pourable.",
            "5. Float cream on top by pouring over a spoon."
        ),
        imageCarousel = listOf(
            R.drawable.irish_1,
            R.drawable.irish_2,
            R.drawable.irish_3,
            R.drawable.irish_4,
            R.drawable.irish_5
        )
    ),
    // vienna
    CoffeeDetails(
        id = 17,
        origin = "Austria",
        type = "Vienna",
        instructions = listOf(
            "1. Brew two shots of strong espresso.",
            "2. Add sugar to taste (optional).",
            "3. Pour espresso into a tall glass.",
            "4. Top with whipped cream.",
            "5. Sprinkle chocolate or cinnamon on top."
        ),
        imageCarousel = listOf(
            R.drawable.vienna_1,
            R.drawable.vienna_2,
            R.drawable.vienna_3,
            R.drawable.vienna_4,
            R.drawable.vienna_5
        )
    ),
    // breve
    CoffeeDetails(
        id = 18,
        origin = "United States",
        type = "Breve",
        instructions = listOf(
            "1. Brew a shot of espresso.",
            "2. Steam half-and-half of milk and cream.",
            "3. Froth it lightly to a creamy texture.",
            "4. Pour the steamed half-and-half over the espresso.",
            "5. Serve hot and enjoy its rich texture."
        ),
        imageCarousel = listOf(
            R.drawable.breve_1,
            R.drawable.breve_2,
            R.drawable.breve_3,
            R.drawable.breve_4,
            R.drawable.breve_5
        )
    ),
    // nitro
    CoffeeDetails(
        id = 19,
        origin = "United States",
        type = "Nitro Cold Brew",
        instructions = listOf(
            "1. Coarsely grind coffee beans.",
            "2. Steep in cold water for 12-24 hours.",
            "3. Strain the coffee to remove grounds.",
            "4. Infuse with nitrogen.",
            "5. Serve cold with a creamy head."
        ),
        imageCarousel = listOf(
            R.drawable.nitro_1,
            R.drawable.nitro_2,
            R.drawable.nitro_3,
            R.drawable.nitro_4,
            R.drawable.nitro_5
        )
    ),
    // cafe lait
    CoffeeDetails(
        id = 20,
        origin = "France",
        type = "Café au Lait",
        instructions = listOf(
            "1. Brew a strong drip or French press coffee.",
            "2. Heat milk without frothing.",
            "3. Pour equal parts of coffee and hot milk.",
            "4. Stir gently to combine.",
            "5. Serve in a wide mug."
        ),
        imageCarousel = listOf(
            R.drawable.cafe_1,
            R.drawable.cafe_2,
            R.drawable.cafe_3,
            R.drawable.cafe_4,
            R.drawable.cafe_5
        )
    ),
    // einspanner
    CoffeeDetails(
        id = 21,
        origin = "Austria",
        type = "Einspänner",
        instructions = listOf(
            "1. Brew a double shot of espresso.",
            "2. Pour into a tall glass or cup.",
            "3. Whip heavy cream until soft peaks form.",
            "4. Spoon cream gently over espresso.",
            "5. Serve without stirring."
        ),
        imageCarousel = listOf(
            R.drawable.eins_1,
            R.drawable.eins_2,
            R.drawable.eins_3,
            R.drawable.eins_4,
            R.drawable.eins_5
        )
    ),
    // cafe bombon
    CoffeeDetails(
        id = 22,
        origin = "Spain",
        type = "Café Bombón",
        instructions = listOf(
            "1. Brew a shot of espresso.",
            "2. Pour condensed milk into a glass.",
            "3. Slowly pour espresso over milk.",
            "4. Let layers settle visibly.",
            "5. Stir before drinking, if preferred."
        ),
        imageCarousel = listOf(
            R.drawable.bombon_1,
            R.drawable.bombon_2,
            R.drawable.bombon_3,
            R.drawable.bombon_4,
            R.drawable.bombon_5
        )
    ),
    // cafe cubano
    CoffeeDetails(
        id = 23,
        origin = "Cuba",
        type = "Café Cubano",
        instructions = listOf(
            "1. Brew espresso using dark roast beans.",
            "2. Add sugar to first drops of espresso.",
            "3. Whip sugar and dropas into foam.",
            "4. Pour in the rest of the espresso.",
            "5. Mix well and serve small."
        ),
        imageCarousel = listOf(
            R.drawable.cubano_1,
            R.drawable.cubano_2,
            R.drawable.cubano_3,
            R.drawable.cubano_4,
            R.drawable.cubano_5
        )
    ),
    // mazagran
    CoffeeDetails(
        id = 24,
        origin = "Algeria",
        type = "Mazagran",
        instructions = listOf(
            "1. Brew strong black coffee.",
            "2. Chill or pour over ice.",
            "3. Add lemon juice or a lemon slice.",
            "4. Sweeten with sugar or syrup.",
            "5. Stir and serve cold."
        ),
        imageCarousel = listOf(
            R.drawable.maza_1,
            R.drawable.maza_2,
            R.drawable.maza_3,
            R.drawable.maza_4,
            R.drawable.maza_5
        )
    ),
    // bicerin
    CoffeeDetails(
        id = 25,
        origin = "Italy",
        type = "Bicerin",
        instructions = listOf(
            "1. Warm chocolate and pour into a glass.",
            "2. Brew a shot of espresso.",
            "3. Gently pour espresso over chocolate.",
            "4. Steam milk and pour on top.",
            "5. Don't stir, serve with layers visible."
        ),
        imageCarousel = listOf(
            R.drawable.bicerin_1,
            R.drawable.bicerin_2,
            R.drawable.bicerin_3,
            R.drawable.bicerin_4,
            R.drawable.bicerin_5
        )
    ),
    // kopi tubruk
    CoffeeDetails(
        id = 26,
        origin = "Indonesia",
        type = "Kopi Tubruk",
        instructions = listOf(
            "1. Add 1-2 tsp of coarse coffee to a glass.",
            "2. Pour in hot boiling water.",
            "3. Stir and let grounds sink.",
            "4. Add sugar if desired.",
            "5. Sip slowly, grounds stay at the bottom."
        ),
        imageCarousel = listOf(
            R.drawable.kopi_1,
            R.drawable.kopi_2,
            R.drawable.kopi_3,
            R.drawable.kopi_4,
            R.drawable.kopi_5
        )
    )


)