package price

import specification.*
import java.util.*
import java.time.LocalDateTime

class ChildrenPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return 1000
    }
}