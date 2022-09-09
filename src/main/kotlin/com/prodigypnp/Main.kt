package com.prodigypnp

import com.prodigypnp.libs.fills
import java.io.FileReader

fun main(args: Array<String>) : Unit {

    if (args.isEmpty() || !args.contains("--file")) {
        println("make sure to pass an option for the input file")
        println("EXAMPLE: java -jar ./build/PNPscript.jar --file ./examples/gold.pnps")
        return
    }

    val file = FileReader(args[args.indexOf("--file") + 1]).readText()
    println(Lines(file))

}