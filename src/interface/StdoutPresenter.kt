package `interface`

import TicketCollection

class StdoutPresenter(private val tickets: TicketCollection): Presenter {
    override fun output() {
        println("▼サマリー")
        println("売上: ${"%,d".format(tickets.sum())}円")
        println("")

        println("▼作品別売上")
        tickets.groupByMovies().forEach { t, u ->
            val subTotal = u.sum()
            println("${t}: ${"%,d".format(subTotal)}円")
        }
        println("")

        println("▼料金タイプ別売上")
        tickets.groupByPriceType().forEach { t, u ->
            val subTotal = u.sum()
            println("${t}: ${"%,d".format(subTotal)}円")
        }
    }
}