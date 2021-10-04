fun main() {
    var length = 0
    var i = 1
    while (i > 0) {
        val n = readLine()!!.toInt()
        if (n > 0) length++
        i = n
    }
    println(length)
}
