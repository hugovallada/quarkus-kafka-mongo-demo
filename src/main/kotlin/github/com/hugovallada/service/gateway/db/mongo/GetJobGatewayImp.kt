package github.com.hugovallada.service.gateway.db.mongo

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.domain.gateway.GetJobGateway
import github.com.hugovallada.service.gateway.db.mongo.repository.JobRepository
import github.com.hugovallada.service.translators.toJobDomain
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetJobGatewayImp(private val jobRepository: JobRepository, private val sqlRepository: github.com.hugovallada.service.gateway.db.postgres.repository.JobRepository): GetJobGateway {
    override fun execute(id: String): JobDomain {
        println(sqlRepository.listAll())

        sqlRepository.findById(id)?.run {
            return toJobDomain()
        }

        TODO()
//        jobRepository.findById(ObjectId(id))?.run {
//            return toJobDomain()
//        } ?: throw Exception("")
    }
}