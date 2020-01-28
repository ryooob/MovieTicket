package price

import specification.*
import java.util.*
import java.time.LocalDateTime

class SchoolStudentPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return 1000
    }
}