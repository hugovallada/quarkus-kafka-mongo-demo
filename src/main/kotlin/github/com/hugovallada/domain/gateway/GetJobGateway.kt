package github.com.hugovallada.domain.gateway

import github.com.hugovallada.domain.entity.JobDomain

interface GetJobGateway {

    fun execute(id: String): JobDomain

}