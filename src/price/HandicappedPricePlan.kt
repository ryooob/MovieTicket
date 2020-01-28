package price

import specification.*
import java.util.*
import java.time.LocalDateTime

class HandicappedPricePlan: PricePlan {
    override fun price(datetime: LocalDateTime): Int {
        return 900
    }
}