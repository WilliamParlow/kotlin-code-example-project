fun main(args: Array<String>) {
    var fortune = ""

    while (!fortune.contains("Take it easy")) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}

fun getFortune(day: Int): String {
    return when (day.rem(7)) {
        0 -> "You will have a great day!"
        1 -> "Things will go well for you today."
        2 -> "Enjoy a wonderful day of success."
        3 -> "Be humble and all will turn out well."
        4 -> "Today is a good day for exercising restraint."
        5 -> "Take it easy and enjoy life!"
        6 -> "Treasure your friends because they are your greatest fortune."
        else -> "You are working like a horse!"
    }
}

private fun getBirthday() : Int {
    print("Enter your birthday: ")

    return readLine()?.toIntOrNull() ?: 1
}