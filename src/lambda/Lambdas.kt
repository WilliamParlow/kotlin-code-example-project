fun main(args: Array<String>) {
    waterFilterLambda(40)
    updateDirt(40, waterFilterLambda)
    updateDirt(40, ::waterFilterFun)
    updateDirt(40, {dirty -> dirty + 50})
    updateDirt(40) {dirty -> dirty + 50} // Just if lambda is last param
}

val waterFilterLambda: (Int) -> Int = { dirty -> dirty / 2 }
fun waterFilterFun(dirty: Int): Int {
    return dirty / 2
}

fun updateDirt(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}