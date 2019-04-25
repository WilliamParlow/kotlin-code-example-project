package extensionfunctions

fun String.hasSapces() = find { it == ' ' } != null

fun main() {
    println("Eu tenho espaco".hasSapces())
    println("Eunaotenhoespaco".hasSapces())
}