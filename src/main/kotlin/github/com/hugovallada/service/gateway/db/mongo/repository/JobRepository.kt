package github.com.hugovallada.service.gateway.db.mongo.repository

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.service.gateway.db.mongo.model.JobDocument
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class JobRepository : PanacheMongoRepository<JobDocument> {
}