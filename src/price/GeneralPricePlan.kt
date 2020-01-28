package price

import specification.*
import java.util.*
import java.time.LocalDateTime

class GeneralPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return when {
            MovieDaySpecification().isSatisfiedBy(datetime) -> {
                1100
            }
            LateShowSpecification().isSatisfiedBy(datetime) -> {
                1300
            }
            else -> {
                1800
            }
        }
    }
}