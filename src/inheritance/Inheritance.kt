package inheritance

fun main() {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
}

interface FishActions {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus : FishActions by PrintingFishAction("A lot of algae"), FishColor by GoldenColor

object GoldenColor : FishColor {
    override val color: String = "Golden"
}

class PrintingFishAction(val food:  String) : FishActions {
    override fun eat() {
        println(food)
    }
}