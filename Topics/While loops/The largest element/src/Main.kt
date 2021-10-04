fun main() {
    val list = mutableListOf<Int>()
    do {
        val n = readLine()!!.toInt()
        list.add(n)
    } while (n > 0)
    println(list.maxOrNull())
}
