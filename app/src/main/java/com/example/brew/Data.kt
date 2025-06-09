package com.example.brew

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DrawableStringsSetup(
    @DrawableRes val drawable: Int,
    @StringRes val coffeeText: Int,
    @StringRes val biotext: Int,
    @StringRes val strengthText: Int
)

val coffeData = listOf(
    // espresso
    DrawableStringsSetup(
        R.drawable.espresso,
        R.string.espresso,
        R.string.espresso_bio,
        R.string.strong
    ),
    // americano
    DrawableStringsSetup(
        R.drawable.americano,
        R.string.americano,
        R.string.americano_bio,
        R.string.balanced
    ),
    //latte
    DrawableStringsSetup(
        R.drawable.latte,
        R.string.latte,
        R.string.latte_bio,
        R.string.mild
    ),
    // cappuccino
    DrawableStringsSetup(
        R.drawable.cappuccino,
        R.string.cappuccino,
        R.string.cappuccino_bio,
        R.string.balanced
    ),
    // flat white
    DrawableStringsSetup(
        R.drawable.flatwhite,
        R.string.flat_white,
        R.string.flatwhite_bio,
        R.string.bold
    ),
    // mocha
    DrawableStringsSetup(
        R.drawable.mocha,
        R.string.mocha,
        R.string.mocha_bio,
        R.string.mild
    ),
    // macchiato
    DrawableStringsSetup(
        R.drawable.macchiato,
        R.string.macchiato,
        R.string.macchiato_bio,
        R.string.bold
    )

)