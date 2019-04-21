package aquarium

abstract class AquariumFIsh {

    abstract val color: String
}

class Shark: AquariumFIsh(), FishAction {

    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFIsh(), FishAction {

    override val color = "gold"

    override fun eat() {
        println("much on algae")
    }
}

interface FishAction {

    fun eat()
}