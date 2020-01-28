package specification

import java.time.DayOfWeek
import java.util.*
import java.time.LocalDateTime

interface Specification {
    fun isSatisfiedBy(dateTime: LocalDateTime): Boolean
}

class WeekdaysSpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return !HolidaysSpecification().isSatisfiedBy(dateTime)
    }
}

class HolidaysSpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return when (dateTime.dayOfWeek) {
            DayOfWeek.SUNDAY -> true
            DayOfWeek.SATURDAY -> true
            else -> false
        }
    }
}

class LateShowSpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return dateTime.hour >= 20
    }
}

class EarlyShowSpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return !LateShowSpecification().isSatisfiedBy(dateTime)
    }
}

class MovieDaySpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return dateTime.dayOfMonth == 1
    }
}

class HolidaysEarlyShowSpecification(): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return AndSpecification(
            HolidaysSpecification(), EarlyShowSpecification()
        ).isSatisfiedBy(dateTime)
    }
}

class AndSpecification(private val firstSpecification: Specification, private val secondSpecification: Specification): Specification {
    override fun isSatisfiedBy(dateTime: LocalDateTime): Boolean {
        return firstSpecification.isSatisfiedBy(dateTime) && secondSpecification.isSatisfiedBy(dateTime)
    }
}
