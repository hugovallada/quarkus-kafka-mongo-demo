package github.com.hugovallada.service.dto

import java.math.BigDecimal

@JvmRecord
data class JobRequest(val name: String, val salary: BigDecimal, val monthsOfContract: Int)

@JvmRecord
data class JobResponse(val name: String, val salary: BigDecimal, val monthsOfContract: Int, val fulfilled: Boolean)
