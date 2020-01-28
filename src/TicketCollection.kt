import entity.Ticket
import java.util.*


class TicketCollection() {
    private val tickets: MutableList<Ticket> = mutableListOf()

    fun add(ticket: Ticket) {
        tickets.add(ticket)
    }

    fun sum(): Int {
        return tickets.sumBy { it.price() }
    }

    fun groupByMovies(): Map<String, List<Int>> {
        return tickets.groupBy({
            it.movie.name()
        }, {
            it.price()
        })
    }

    fun groupByPriceType(): Map<String, List<Int>> {
        return tickets.groupBy({
            it.priceType.value
        }, {
            it.price()
        })
    }
}
