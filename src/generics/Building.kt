package generics

class Building<out T : BaseBuildingMaterial>(private val material: T) {

    private val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("Material type: ${material::class.simpleName} - material needed: $actualMaterialsNeeded")
    }
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

fun main() {

    val woodBuilding = Building(Wood())
    val brickBuilding = Building(Brick())

    woodBuilding.build()
    brickBuilding.build()

    println(isSmallBuilding(woodBuilding))
    println(isSmallBuilding(brickBuilding))
}

