package price

import specification.*
import java.util.*
import java.time.LocalDateTime

class CinemaCitizenPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return when {
            MovieDaySpecification().isSatisfiedBy(datetime) -> {
                1100
            }
            HolidaysEarlyShowSpecification().isSatisfiedBy(datetime) -> {
                1300
            }
            else -> {
                1000
            }
        }
    }
}