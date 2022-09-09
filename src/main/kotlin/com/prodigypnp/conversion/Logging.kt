package com.prodigypnp.conversion

import com.prodigypnp.libs.Fills

fun convLog (code: String, Fills : Fills) : String {

    Fills.Toast = true;

    val split = code.split("~ ")

    val title = if (split.size > 1) split[1] else ""
    val html = if (split.size > 2) split[2] else ""
    val icon = if (split.size > 3) split[3] else ""

    return """
        pnpscript.fills.Toast.fire({
            title: `$title`,
            html: `$html`,
            icon: `${if (icon == "info" || icon == "success" || icon == "warning" || icon == "question" || icon == "error") icon else ""}`,
        });
    """.trimIndent()
}