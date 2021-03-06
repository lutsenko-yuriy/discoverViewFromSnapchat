package com.yurich.discoverviewfromsnapchat

import java.util.*

/**
 * Created by yurich on 15.06.17.
 */
object StringsModel {
    val strings = listOf<String>(
            "Tree Of The Sea",
            "Hero Of The Ancestors",
            "Witches Of The Gods",
            "Turtles Without Shame",
            "Invaders And Traitors",
            "Turtles And Rats",
            "Source Without A Conscience",
            "Inception Of The Forsaken",
            "Helping Technology",
            "Prepare For My Husband",
            "Agent With Honor",
            "Foe Of Earth",
            "Serpents Of Fortune",
            "Foes Of The Light",
            "Vultures And Men",
            "Soldiers And Lions",
            "Future Of The Sea",
            "Annihilation Of Fortune",
            "Escaping My Future",
            "Temptations In The Shadows",
            "Witch With Strength",
            "Raven Of Reality",
            "Swindlers Of Fire",
            "Creators Of The Void",
            "Creators And Butchers",
            "Vultures And Rats",
            "Staff Of The Stars",
            "Surprise Of Yesterday",
            "Guarded By My Dreams",
            "Begging In The City"
    )

    operator fun get(i: Int) = strings[i]

    fun randomStrings(amount: Int): List<String> {
        val list = mutableListOf<String>()
        val random = Random()
        for (i in 1..amount) {
            list.add(strings[random.nextInt(strings.size)])
        }
        return list
    }
}