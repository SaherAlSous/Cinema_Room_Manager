package cinema

import kotlin.system.exitProcess

var totalSold = 0
var currentIncome = 0

fun main() {
    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val seats = readLine()!!.toInt()
    val cinema = MutableList(rows) {MutableList(seats) {" S"} }
    val cinemaSize = rows * seats
    getCommand(cinema, cinemaSize)
}

fun getCommand(cinema: MutableList<MutableList<String>>, cinemaSize: Int) {
    println("""
        
       1. Show the seats
       2. Buy a ticket
       3. Statistics
       0. Exit   
    """.trimIndent())
    val n = readLine()!!.toInt()
    do {
        when (n) {
            1 -> printCinema(cinema, cinemaSize)
            2 -> getTicketPrice(cinema, cinemaSize)
            3 -> statistics(cinema, cinemaSize)
        }
    } while (n != 0)
}

fun statistics(cinema: MutableList<MutableList<String>>, cinemaSize: Int) {
    println("""
        Number of purchased tickets: $totalSold
        Percentage: ${String.format("%.2f", (totalSold.toDouble() / cinemaSize.toDouble()) * 100 )}%
        Current income: $$currentIncome
        Total income: $${if (cinemaSize <= 60) cinemaSize * 10 else cinema.size / 2 * 9 * 10 + (cinema.size - cinema.size / 2) * 9 * 8} 
    """.trimIndent()
    )
    getCommand(cinema, cinemaSize)
}

fun getTicketPrice(cinema: MutableList<MutableList<String>>, cinemaSize: Int) {
    println("Enter a row number:")
    val row = readLine()!!.toInt()
    println("Enter a seat number in that row:")
    val seat = readLine()!!.toInt()
    checkCommand(cinema, cinemaSize, row,seat)
}

fun checkCommand(cinema: MutableList<MutableList<String>>, cinemaSize: Int, row: Int, seat: Int) {
    try {
    if (cinema[row - 1][seat - 1] == " B") {
        println("That ticket has already been purchased!")
        getTicketPrice(cinema, cinemaSize)
    } else if (cinemaSize <= 60) printReservation(cinema,row, seat, true) else printReservation(cinema, row, seat, false)
        getCommand(cinema, cinemaSize)
    } catch (e: IndexOutOfBoundsException) {
        println("Wrong input!")
    } finally {
        getTicketPrice(cinema, cinemaSize)
    }
}

fun printReservation(cinema: MutableList<MutableList<String>>, chosenRow: Int, seat: Int, Boolean: Boolean) {
    cinema[chosenRow - 1][seat - 1] = " B"
    val ticket = if (Boolean) 10 else if (chosenRow <= cinema.size / 2) 10 else 8
    println("Ticket price: $$ticket")
    totalSold++
    currentIncome+=ticket
}

fun printCinema(cinema: MutableList<MutableList<String>>, cinemaSize: Int) {
    println("Cinema:")
    print(" ")
    for (row in cinema[0].indices) {
        print(" ${row + 1}")
    }
    println()
    for (row in cinema.indices) {
        println("${row + 1}${cinema[row].joinToString("")}")
    }
    getCommand(cinema, cinemaSize)
}