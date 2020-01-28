package entity

import price.*

enum class PriceType(val value: String) {
    CINEMA_CITIZEN("シネマシティズン") {
        override fun pricePlan(): PricePlan {
            return CinemaCitizenPricePlan()
        }
    },
    SENIOR_CINEMA_CITIZEN("シネマシティズン（60才以上）"){
        override fun pricePlan(): PricePlan {
            return SeniorCinemaCitizenPricePlan()
        }
    },
    GENERAL("一般"){
        override fun pricePlan(): PricePlan {
            return GeneralPricePlan()
        }
    },
    SENIOR("シニア（70才以上）"){
        override fun pricePlan(): PricePlan {
            return SeniorPricePlan()
        }
    },
    STUDENT("学生（大・専）"){
        override fun pricePlan(): PricePlan {
            return StudentPricePlan()
        }
    },
    SCHOOL_STUDENT("中・高校生"){
        override fun pricePlan(): PricePlan {
            return SchoolStudentPricePlan()
        }
    },
    CHILDREN("幼児（3才以上）・小学生"){
        override fun pricePlan(): PricePlan {
            return ChildrenPricePlan()
        }
    },
    SENIOR_HANDICAPPED("障がい者（学生以上）"){
        override fun pricePlan(): PricePlan {
            return SeniorHandicappedPricePlan()
        }
    },
    JUNIOR_HANDICAPPED("障がい者（高校以下）"){
        override fun pricePlan(): PricePlan {
            return HandicappedPricePlan()
        }
    };
    abstract fun pricePlan(): PricePlan
    companion object {
        private val map = values().associateBy(PriceType::value)
        fun fromString(type: String): PriceType {
            return map[type]!!
        }
    }
}
