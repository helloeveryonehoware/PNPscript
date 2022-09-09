package com.prodigypnp

import com.prodigypnp.conversion.convLog

fun Lines (script: String) : String {

    /** If CRLF detected, split by CRLF. Otherwise, split by LF */
    val all = if (script.contains("\r\n")) script.split("\r\n") else script.split("\n")

    /** Output lines of code */
    val output : ArrayList<String> = ArrayList()


    for (line in all) {

        if (line.startsWith("~")) {
            output.add(convLog(line))
        }


    }

    return output.joinToString("")
}