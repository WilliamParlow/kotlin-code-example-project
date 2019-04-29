package inline

fun main() {
    fishExamples()
}

data class Fish(var name: String)

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name) {
        capitalize()
    }
}

// With inline functions, Kotlin will not create a new instance of object when the lambda is called. Yes, lambda are objects
// and an instance is created on every call. Inline get the instructions defined inside the lambda ant places inline the
// code. It means zero overhead.
inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}