package com.example.brew

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// strings setup for the coffee element
data class DrawableStringsSetup(
    val id: Int,
    @DrawableRes val drawable: Int,
    @StringRes val coffeeText: Int,
    @StringRes val biotext: Int,
    @StringRes val strengthText: Int
)

data class Cafe(
    val name: String,
    val lat: Double,
    val lon: Double
)

// first thing seen in json, whole json response
data class FeatureCollection(
    val type: String,
    val features: List<Feature>  // cafe features list
)

// feature details (cafe with properties)
data class Feature(
    val type: String,
    val properties: Properties, // cafe details
    val geometry: Geometry  // coords
)

// cafe properties
data class Properties(
    val name: String?  // just need name 4 now
)


// list that holds the data for each coffee element
val coffeeData = listOf(
    // espresso
    DrawableStringsSetup(
        id = 1,
        R.drawable.espresso,
        R.string.espresso,
        R.string.espresso_bio,
        R.string.strong
    ),
    // americano
    DrawableStringsSetup(
        id = 2,
        R.drawable.americano,
        R.string.americano,
        R.string.americano_bio,
        R.string.balanced
    ),
    //latte
    DrawableStringsSetup(
        id = 3,
        R.drawable.latte,
        R.string.latte,
        R.string.latte_bio,
        R.string.mild
    ),
    // cappuccino
    DrawableStringsSetup(
        id = 4,
        R.drawable.cappuccino,
        R.string.cappuccino,
        R.string.cappuccino_bio,
        R.string.balanced
    ),
    // flat white
    DrawableStringsSetup(
        id = 5,
        R.drawable.flatwhite,
        R.string.flat_white,
        R.string.flatwhite_bio,
        R.string.bold
    ),
    // mocha
    DrawableStringsSetup(
        id = 6,
        R.drawable.mocha,
        R.string.mocha,
        R.string.mocha_bio,
        R.string.mild
    ),
    // macchiato
    DrawableStringsSetup(
        id = 7,
        R.drawable.macchiato,
        R.string.macchiato,
        R.string.macchiato_bio,
        R.string.bold
    ),
    // cold brew
    DrawableStringsSetup(
        id = 8,
        R.drawable.coldbrew,
        R.string.cold_brew,
        R.string.coldbrew_bio,
        R.string.bold
    ),
    // long black
    DrawableStringsSetup(
        id = 9,
        R.drawable.longblack,
        R.string.long_black,
        R.string.longblack_bio,
        R.string.strong
    ),
    // turkish
    DrawableStringsSetup(
        id = 10,
        R.drawable.turkish,
        R.string.turkish_coffee,
        R.string.turkish_bio,
        R.string.strong
    )

)