package com.prodigypnp.conversion

fun convLog (code: String) : String {
    return code.replaceFirst("~ ", "console.log(`") + "`);"
}