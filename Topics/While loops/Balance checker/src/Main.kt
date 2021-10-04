fun main() {
    var wallet = readLine()!!.toInt()
    val purchase: MutableList<Int> = readLine()!!.split(" ").map { it.toInt() } as MutableList<Int>
    var i = 0
    while (i < purchase.size && wallet >= purchase[i]) {
        wallet -= purchase[i]
        purchase[i] = 0
        i++
    }
    val msg =
        if (wallet >= purchase.sum()) {
            "Thank you for choosing us to manage your account! Your balance is $wallet."
            } else {
                "Error, insufficient funds for the purchase. Your balance is $wallet, but you need ${purchase.sum()}."}
    println(msg)
}
