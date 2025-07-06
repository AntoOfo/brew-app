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
    val street: String,
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
    val name: String?,
    val street: String?
)

// coords
data class Geometry(
    val type: String,
    val coordinates: List<Double>
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
    ),
    // ristretto
    DrawableStringsSetup(
        id = 11,
        R.drawable.ristretto,
        R.string.ristretto,
        R.string.ristretto_bio,
        R.string.strong
    ),
    //affogato
    DrawableStringsSetup(
        id = 12,
        R.drawable.affogato,
        R.string.affogato,
        R.string.affogato_bio,
        R.string.balanced
    ),
    // cortado
    DrawableStringsSetup(
        id = 13,
        R.drawable.cortado,
        R.string.cortado,
        R.string.cortado_bio,
        R.string.balanced
    ),
    // red eye
    DrawableStringsSetup(
        id = 14,
        R.drawable.redeye,
        R.string.red_eye,
        R.string.redeye_bio,
        R.string.strong
    ),
    // doppio
    DrawableStringsSetup(
        id = 15,
        R.drawable.doppio,
        R.string.doppio,
        R.string.doppio_bio,
        R.string.bold
    ),
    // irish coffee
    DrawableStringsSetup(
        id = 16,
        R.drawable.irishcoffee,
        R.string.irish_coffee,
        R.string.irish_bio,
        R.string.bold
    ),
    // vienna
    DrawableStringsSetup(
        id = 17,
        R.drawable.vienna,
        R.string.vienna,
        R.string.vienna_bio,
        R.string.balanced
    ),
    // breve
    DrawableStringsSetup(
        id = 18,
        R.drawable.breve,
        R.string.breve,
        R.string.breve_bio,
        R.string.mild
    ),
    // nitro
    DrawableStringsSetup(
        id = 19,
        R.drawable.nitro,
        R.string.nitro_cold_brew,
        R.string.nitro_bio,
        R.string.bold
    ),
    // cafe lait
    DrawableStringsSetup(
        id = 20,
        R.drawable.cafelait,
        R.string.cafe_lait,
        R.string.cafelait_bio,
        R.string.mild
    ),
    // einspanner
    DrawableStringsSetup(
        id = 21,
        R.drawable.einspanner,
        R.string.eins,
        R.string.eins_bio,
        R.string.bold
    ),
    // cafe bombon
    DrawableStringsSetup(
        id = 22,
        R.drawable.bombon,
        R.string.cafe_bombon,
        R.string.bombon_bio,
        R.string.mild
    ),
    // cafe cubano
    DrawableStringsSetup(
        id = 23,
        R.drawable.cubano,
        R.string.cafe_cubano,
        R.string.cubano_bio,
        R.string.strong
    ),
    // mazagran
    DrawableStringsSetup(
        id = 24,
        R.drawable.mazagran,
        R.string.mazagran,
        R.string.maza_bio,
        R.string.balanced
    ),
    // bicerin
    DrawableStringsSetup(
        id = 25,
        R.drawable.bicerin,
        R.string.bicerin,
        R.string.bicerin_bio,
        R.string.bold
    ),
    // kopi tubruk
    DrawableStringsSetup(
        id = 26,
        R.drawable.kopi,
        R.string.kopi,
        R.string.kopi_bio,
        R.string.strong
    )


)