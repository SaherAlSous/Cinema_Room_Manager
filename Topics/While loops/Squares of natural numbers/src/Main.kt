fun main() {
    val n = readLine()!!.toInt()
    var i = 1
    var j = i
    while (j <= n) {
        println(j)
        i++
        j = i * i
    }
}
