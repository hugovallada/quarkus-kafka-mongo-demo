package github.com.hugovallada.service.gateway.db.postgres.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Job(
    @Id
    val id: String,
    val name: String,
    val salary: BigDecimal,
    val monthsContract: Int,
    val fulfilled: Boolean
)