package com.prodigypnp

import com.prodigypnp.conversion.Player
import com.prodigypnp.conversion.convLog
import com.prodigypnp.libs.Fills


fun Lines (script: String) : String {

    /** Dependency fills */
    val fills : Fills = Fills();

    /** If CRLF detected, split by CRLF. Otherwise, split by LF */
    val all = if (script.contains("\r\n")) script.split("\r\n") else script.split("\n")

    /** Output lines of code */
    val output : ArrayList<String> = ArrayList()



    for (line in all) {

        if (line.startsWith("~")) {
            output.add(convLog(line, fills))
            continue
        }

        if (line.contains("me.")) {
            output.add(Player.gold(line))
            continue
        }

    }



    return """
        
        (()=>{
            ${fills.getAll() /* Add fills */};
            ${output.joinToString("") /* Add hack script */}
        })();
        
        """.trimIndent().replace("\n", "")
}