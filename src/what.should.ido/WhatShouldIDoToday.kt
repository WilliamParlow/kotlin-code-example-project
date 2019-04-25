fun main() {
    println(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("happy", temperature = 30.0))
    println(whatShouldIDoToday("sad", weather = "rainy"))
    println(whatShouldIDoToday("sad"))
    println(whatShouldIDoToday("happy", "rainy", temperature = 32.0))
    println(whatShouldIDoToday("very sad", temperature = 32.0))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Double = 24.0): String {
    return when {
        isHappyAndSunnyAndIsNotHot(mood, weather, temperature) -> "You should go for a walk"
        isHappyAndSunnyAndIsHot(mood, weather, temperature) -> "You should go to beach"
        isHappyAndRainy(mood, weather) -> "You should watch a movie and drink chocolate"
        isSadAndSunny(mood, weather) -> "You should go out and see the day rise"
        isSadAndRainy(mood, weather) -> "You should watch a movie while eat pop corn"
        else -> "You should find a IA that's make you happy"
    }
}

fun isHappyAndSunnyAndIsNotHot(mood: String, weather: String, temperature: Double) =
    mood == "happy" && weather == "sunny" && temperature < 26

fun isHappyAndSunnyAndIsHot(mood: String, weather: String, temperature: Double) =
    mood == "happy" && weather == "sunny" && temperature >= 26

fun isHappyAndRainy(mood: String, weather: String) = mood == "happy" && weather == "rainy"

fun isSadAndSunny(mood: String, weather: String) = mood == "sad" && weather == "sunny"

fun isSadAndRainy(mood: String, weather: String) = mood == "sad" && weather == "rainy"