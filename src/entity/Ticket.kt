package entity

import java.util.*
import java.time.LocalDateTime

class Ticket(val movie: Movie, val priceType: PriceType, val timeDate: LocalDateTime) {
    public fun price(): Int {
        val plan = priceType.pricePlan()
        return plan.price(timeDate)
    }

    fun print() {
        println("${movie.name()} ${this.price()}円")
    }
}
