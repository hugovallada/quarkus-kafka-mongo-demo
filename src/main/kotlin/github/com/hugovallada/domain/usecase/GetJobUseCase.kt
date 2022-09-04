package github.com.hugovallada.domain.usecase

import github.com.hugovallada.domain.gateway.GetJobGateway
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetJobUseCase(private val getJobGateway: GetJobGateway) {

    fun execute(id: String) = getJobGateway.execute(id)
}