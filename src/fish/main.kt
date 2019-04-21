package fish

fun main(args: Array<String>) {

    val fish1 = Fish(false, 18)
    val fish2 = Fish("I'm using the secondary constructor")

    println("This fish friendly is ${fish1.friendly} and size is ${fish1.size}")
    println("This fish friendly is ${fish2.friendly} and size is ${fish2.size}")
}