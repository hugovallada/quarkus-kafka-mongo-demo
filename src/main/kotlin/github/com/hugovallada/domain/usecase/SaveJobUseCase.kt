package github.com.hugovallada.domain.usecase

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.domain.gateway.SaveJobGateway
import github.com.hugovallada.domain.gateway.SendToSqlGateway
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class SaveJobUseCase(private val jobGateway: SaveJobGateway, private val sendToSqlGateway: SendToSqlGateway) {


    fun execute(jobDomain: JobDomain): String {
        with(jobGateway.save(jobDomain)) {
            sendToSqlGateway.execute(jobDomain.copy(id = this))
            return this
        }
    }


}