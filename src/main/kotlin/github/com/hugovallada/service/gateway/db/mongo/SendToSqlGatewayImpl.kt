package github.com.hugovallada.service.gateway.db.mongo

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.domain.gateway.SendToSqlGateway
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SendToSqlGatewayImpl(@Channel("jobs") private val emmiter: Emitter<JobDomain>): SendToSqlGateway {
    override fun execute(jobDomain: JobDomain) {
        emmiter.send(jobDomain)
    }
}