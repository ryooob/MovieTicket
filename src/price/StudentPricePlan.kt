package price

import specification.*
import java.time.LocalDateTime
import java.util.*

class StudentPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return when {
            MovieDaySpecification().isSatisfiedBy(datetime) -> {
                1100
            }
            LateShowSpecification().isSatisfiedBy(datetime) -> {
                1300
            }
            else -> {
                1500
            }
        }
    }
}