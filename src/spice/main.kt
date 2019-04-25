package spice

fun main() {

    val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val heatSpices = spices.filter { it.heat > 5 }

    heatSpices.forEach { println("spice ${it.name} is ${it.heat}") }
}