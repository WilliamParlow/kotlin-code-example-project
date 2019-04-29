package highorderfunctions

fun main() {
    fishExamples()
}

data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name) {
        println(capitalize())
    }

    println(fish.run { name })

    println(fish.apply { })

    val fish2 = Fish("Splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
            .let { it + 31 })

    val numbers: List<Int> = listOf(1,2,3,4,5,6,7,8,9,0)

    println(withfilterNumberListByDivisor(numbers) {
        filter { it.rem(3) == 0 }
    })
}

fun withfilterNumberListByDivisor(numbers: List<Int>, block: List<Int>.() -> List<Int>): List<Int> = numbers.block()

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}