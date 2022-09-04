package github.com.hugovallada.domain.entity

import java.math.BigDecimal

@JvmRecord
data class JobDomain(val name: String, val salary: BigDecimal, val contractMonths: Int, val fulfilled: Boolean = false, val id: String? = null)
