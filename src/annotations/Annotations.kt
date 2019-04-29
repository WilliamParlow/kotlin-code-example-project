package annotations

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

class InteropFish {
    companion object {
        @JvmStatic fun interop() {
            println("InteropFish")
        }
    }

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}
}

annotation class ImAPlant

fun reflections() {
    val classObj = Plant::class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name)
    }

    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    val annoted = classObj.findAnnotation<ImAPlant>()

    annoted?.apply {
        println("Found a Plant annotation")
    }
}