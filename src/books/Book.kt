package books

open class Book(var title: String = "", var author: String = "") {

    private var currentPage = 1

    open fun readPage() {
        this.currentPage++
    }
}

class EBook(var format: String = "text"): Book() {

    private var wordsRead: Int = 250

    override fun readPage() {
        wordsRead = wordsRead.plus(250)
    }
}