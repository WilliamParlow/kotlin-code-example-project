package generics

class Buildings<T : BaseBuildingMaterial>(private val material: T) {

    private val baseMaterialsNeeded: Int = 100
    private val actualMaterialsNeeded: Int get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("Material type: ${material::class.simpleName} - material needed: $actualMaterialsNeeded")
    }
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

fun main() {

    val woodBuilding = Buildings(Wood())
    val brickBuilding = Buildings(Brick())

    woodBuilding.build()
    brickBuilding.build()
}

