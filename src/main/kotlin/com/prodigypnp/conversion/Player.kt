package com.prodigypnp.conversion

import com.prodigypnp.func.match
import java.lang.Integer.parseInt

fun convPlayer (code : String) : String {
    if (code.match("me.gold") !== "") return Player.gold(code)

    return Player.fallback(code)
}



object Player {

    fun gold (code : String) : String {
        val match = code.match("me.gold")

        val amount : Int = parseInt(code.filter { it.isDigit() })

        if (amount > 10000000) {
            throw Exception("Issue in [$code] - gold value must not be above 10 million to prevent 418s")
        } else {
            return "_.player.data.gold=$amount;"
        }

    }

    fun fallback (code : String) : String {
        val match = code.match("me.")

        val beforeEqualP = code.replace(match, "_.player.").substringBefore("=");
        val beforeEqualPD = code.replace(match, "_.player.data.").substringBefore("=");

        val atPlayer = code.replace(match, "_.player.");
        val atPlayerData = code.replace(match, "_.player.data.");

        return """
            
            if ($beforeEqualP) {
                $atPlayer;
            } else if (${beforeEqualPD}) {
                $atPlayerData;
            } else {
                console.error("This didn't work.");
            };

            
        """.trimIndent().replace("    ", "").replace("\n", "");
    }

}