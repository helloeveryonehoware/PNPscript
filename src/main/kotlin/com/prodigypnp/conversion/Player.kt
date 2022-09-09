package com.prodigypnp.conversion

import com.prodigypnp.func.match

fun convPlayer (code : String) {
}



object Player {

    fun gold (code : String) : String {
        val match = code.match("me.gold")
        return code.replace(match, "_.player.data.gold")
    }

    fun fallback (code : String) : String {
        val match = code.match("me.")
        return code.replace(match, "_.player.")
    }

}