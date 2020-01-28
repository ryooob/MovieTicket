package price

import specification.WeekdaysSpecification
import java.util.*
import java.time.LocalDateTime

interface PricePlan {
    fun price(datetime: LocalDateTime): Int
}
