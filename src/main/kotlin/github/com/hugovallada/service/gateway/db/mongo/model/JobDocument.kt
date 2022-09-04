package github.com.hugovallada.service.gateway.db.mongo.model

import io.quarkus.mongodb.panache.common.MongoEntity
import org.bson.types.ObjectId
import java.math.BigDecimal

@MongoEntity(database = "jobs")
class JobDocument() {
    var id: ObjectId? = null
    lateinit var name: String
    lateinit var salary: BigDecimal
    var monthsContract: Int = 0
    var fulfilled: Boolean = false

    constructor(name: String, salary: BigDecimal, month: Int) : this() {
        this.name = name
        this.salary = salary
        this.monthsContract = month
        this.fulfilled = false
    }
}