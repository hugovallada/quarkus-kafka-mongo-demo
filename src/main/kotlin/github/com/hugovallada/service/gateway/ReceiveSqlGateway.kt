package github.com.hugovallada.service.gateway

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.service.gateway.db.postgres.repository.JobRepository
import github.com.hugovallada.service.translators.toJob
import io.smallrye.reactive.messaging.annotations.Blocking
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.transaction.Transactional

class ReceiveSqlGateway(private val repository: JobRepository) {

    @Incoming("jobs")
    @Blocking
    @Transactional
    fun execute(jobDomain: JobDomain) {
        repository.persist(jobDomain.toJob())
    }
}