package github.com.hugovallada.service.gateway

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.domain.gateway.SaveJobGateway
import github.com.hugovallada.service.gateway.db.mongo.repository.JobRepository
import github.com.hugovallada.service.translators.toJobDocument
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SaveJobGatewayImp(private val jobRepository: JobRepository): SaveJobGateway {
    override fun save(job: JobDomain): String {
        with(job.toJobDocument()) {
            jobRepository.persist(this)
            return id?.toHexString() ?: throw Exception("")
        }
    }
}