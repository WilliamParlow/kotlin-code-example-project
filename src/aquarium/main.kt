package aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

fun buildAquarium() {

    val myAquarium = Aquarium(30, 50, 120)

    println("width: ${myAquarium.width}\n" +
            "height: ${myAquarium.height}\n" +
            "length: ${myAquarium.length}\n" +
            "volume: ${myAquarium.volume}\n")
}

fun makeFish() {

    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark is ${shark.color}, otherwise, pleco is ${pleco.color}")

    feedFish(shark)
    feedFish(pleco)
}

fun feedFish(fish: FishAction) {
    fish.eat()
}