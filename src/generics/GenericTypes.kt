package generics

fun main() {
    genericExample()
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