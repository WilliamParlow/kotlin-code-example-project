package aquarium

import aquarium.enums.Directions

class Map {

    private var mapWidth = 4
    private var mapHeight = 4
    private var x: Int = 1
    private var y: Int = 1
    private val map: Array<Array<Int?>> = Array(mapWidth) { arrayOfNulls<Int>(mapHeight) }

    init {
        initMap()
    }

    fun initMap() {
        x = 1
        y = 1
        for (i in 0 until mapWidth) {
            for (j in 0 until mapHeight) {
                map[i][j] = 0
            }
        }
        map[x][y] = 1
    }

    fun printMap() {
        for (i in 0 until mapWidth) {
            for (j in 0 until mapHeight) {
                print("${map[i][j]} ")
            }
            println()
        }
    }

    fun updateMap(directions: Directions): Boolean {

        map[x][y] = 0

        when (directions) {
            Directions.NORTH -> x--
            Directions.SOUTH -> x++
            Directions.EAST -> y++
            else -> y--
        }

        if (y >= mapHeight || y < 0 || x >= mapWidth || x < 0)
            return false

        map[x][y] = 1

        return true
    }
}

class Game {
    private val north = { path.add(Directions.NORTH); map.updateMap(Directions.NORTH) }
    private val south = { path.add(Directions.SOUTH); map.updateMap(Directions.SOUTH) }
    private val east = { path.add(Directions.EAST); map.updateMap(Directions.EAST) }
    private val west = { path.add(Directions.WEST); map.updateMap(Directions.WEST) }
    private val end = { path.add(Directions.END); println("Game Over: $path - Try Again!"); path.clear(); map.initMap(); false }
    private var path: MutableList<Directions> = mutableListOf(Directions.START)

    val map: Map = Map()

    init {
        println("Aquarium Game! Move your fish and dont bump to the aquarium window! Good Look!\n")
    }

    private inline fun move(where: () -> Boolean): Boolean = where.invoke()

    fun makeMove(direction: String?) {

        val moveResult: Boolean = move(when (direction) {
            "n" -> north
            "s" -> south
            "e" -> east
            "w" -> west
            else -> end
        })

        if (!moveResult)
            end.invoke()
    }
}

fun main() {

    val game = Game()
    println("You are the number one! (1)")

    while (true) {
        game.map.printMap()
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }
}