package aquarium.decorations

fun main() {

    makeDecorations()
}

fun makeDecorations() {

    val dec1 = Decorations("granite")
    val dec2 = Decorations("slate")
    val dec3 = Decorations("slate")

    println(dec2 == dec1)
    println(dec2 == dec3)

    val dec4 = dec3.copy()
    println(dec3)
    println(dec4)

    val dec5 = Decorations2("crystal", "wood", "driver")
    println(dec5)

    val (rocks, woods, driver) = dec5
    println(rocks)
    println(woods)
    println(driver)
}

data class Decorations(val rocks: String)

data class Decorations2(val rocks: String, val woods: String, val driver: String)

enum class Color(val color: String) {
    RED("0xFF0000"),
    GREEN("0x00FF00"),
    BLUE("0x0000FF")
}

sealed class Seal

class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}