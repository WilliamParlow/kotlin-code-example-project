package fish

class Fish (val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    constructor(secondaryValue: String): this(true, 9) {
        println("running secondary constructor with secondaryValue: $secondaryValue")
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }
}

fun printFish() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.friendly}. Its need volume ${fish.size}")
}