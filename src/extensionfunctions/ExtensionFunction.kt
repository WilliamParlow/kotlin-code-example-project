package extensionfunctions

fun main() {
    println("I have spaces".hasSpaces())
    println("Idonothavespaces".hasSpaces())

    val candy = Candy("Strawberry")
    candy.printFlavor()

    val redCandy = ColouredCandy("Red", "cherry")
    redCandy.printFlavor()

    println(redCandy.isRed())
    println(redCandy.isFlavorSizeToLong())
    println(candy.isFlavorSizeToLong())
}

open class Candy(val flavor: String) {

    open fun printFlavor() {
        println("The candy flavor is $flavor")
    }
}

class ColouredCandy(val color: String, flavor: String) : Candy(flavor) {

    override fun printFlavor() {
        println("The candy flavor is $flavor and it color is $color")
    }
}

fun Candy.isFlavorSizeToLong() = flavor.length > 6

fun ColouredCandy.isRed() = color == "Red"

fun String.hasSpaces() = find { it == ' ' } != null