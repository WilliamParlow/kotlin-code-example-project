package generics

fun main() {
    genericExample()
    genericFunctionsExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<T: WaterSupply>(val waterSupply: T) {

    fun addWater() {
        check(!waterSupply.needsProcessed) { "Water supply needs processed" }

        println("adding water from $waterSupply")
    }

}

inline fun <reified T: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is T

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("is water clear?: ${!aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T: WaterSupply> WaterSupply.isTypeOf() = this is T

fun genericFunctionsExample() {
    println("\n ----- Generic Functions")

    val fishStoreWater = Aquarium(FishStoreWater())
    val lakeWater = Aquarium(LakeWater())
    val tapWater = Aquarium(TapWater())

    isWaterClean(fishStoreWater)
    isWaterClean(lakeWater)
    isWaterClean(tapWater)

    println("\nTesting reified: waterSupply is R?: ${fishStoreWater.hasWaterSupplyOfType<TapWater>()}")
    println("Testing reified: waterSupply is R?: ${fishStoreWater.hasWaterSupplyOfType<FishStoreWater>()}")
    println("Testing reified: waterSupply is R?: ${fishStoreWater.hasWaterSupplyOfType<LakeWater>()}")

    println("\nTesting reified: isTypeOf<TapWater>?: ${fishStoreWater.waterSupply.isTypeOf<TapWater>()}")
    println("Testing reified: isTypeOf<FishStoreWater>?: ${fishStoreWater.waterSupply.isTypeOf<FishStoreWater>()}")
    println("Testing reified: isTypeOf<LakeWater>?: ${fishStoreWater.waterSupply.isTypeOf<LakeWater>()}")
}

fun genericExample() {

    val tapWaterAquarium = Aquarium(TapWater())
    val fishStoreWaterAquarium = Aquarium(FishStoreWater())
    val lakeWaterAquarium = Aquarium(LakeWater())

    println(tapWaterAquarium.waterSupply.needsProcessed)
    // tapWaterAquarium.addWater() // descoment to get an error
    tapWaterAquarium.waterSupply.addChemicalCleaners()

    println(tapWaterAquarium.waterSupply.needsProcessed)
    tapWaterAquarium.addWater()

    // -------------------------------------------------------------

    println(fishStoreWaterAquarium.waterSupply.needsProcessed)
    fishStoreWaterAquarium.addWater()

    // -------------------------------------------------------------

    println(lakeWaterAquarium.waterSupply.needsProcessed)
    // lakeWaterAquarium.addWater() // descoment to get an error
    lakeWaterAquarium.waterSupply.filter()

    println(lakeWaterAquarium.waterSupply.needsProcessed)
    lakeWaterAquarium.addWater()
}