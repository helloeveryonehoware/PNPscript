package com.prodigypnp

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.io.FileReader
import kotlin.system.exitProcess


fun main(args: Array<String>) : Unit {

    if (args.isEmpty() || !args.contains("--file")) {
        println("make sure to pass an option for the input file")
        println("EXAMPLE: java -jar ./build/PNPscript.jar --file ./examples/gold.pnps")
        return
    }
    val file = FileReader(args[args.indexOf("--file") + 1]).readText()

    val result = Lines(file)
    println(result)

    if (args.contains("-c") || args.contains("--copy")) {
        Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(result), null)
        println("\n[FINISHED] Copied finished JS to clipboard")
    }

    println("\n[FINISHED] Finished building PNPscript")
    exitProcess(0)
}