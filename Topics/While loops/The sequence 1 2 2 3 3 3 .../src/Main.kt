fun main() {
    val n = readLine()!!.toInt()
    var i = 1
    var j = 1
    while (n >= j) {
        var k = 0
        while (n >= j && i != k) {
            println(i)
            j++
            k++
        }
        i++
    }
}