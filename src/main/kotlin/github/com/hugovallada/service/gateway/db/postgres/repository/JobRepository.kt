package github.com.hugovallada.service.gateway.db.postgres.repository

import github.com.hugovallada.service.gateway.db.postgres.model.Job
import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class JobRepository: PanacheRepository<Job> {
    fun findById(id: String) = find("id", id).firstResult()
}