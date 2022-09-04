package github.com.hugovallada.service.gateway.db.mongo

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.domain.gateway.GetJobGateway
import github.com.hugovallada.service.gateway.db.postgres.repository.JobRepository
import github.com.hugovallada.service.translators.toJobDomain
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetJobGatewayImp(private val jobRepository: JobRepository): GetJobGateway {
    override fun execute(id: String): JobDomain {
        println(jobRepository.listAll())

        jobRepository.findById(id)?.run {
            return toJobDomain()
        } ?: throw IllegalStateException("Not Found")
    }
}