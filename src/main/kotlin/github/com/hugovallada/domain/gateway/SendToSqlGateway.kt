package github.com.hugovallada.domain.gateway

import github.com.hugovallada.domain.entity.JobDomain

interface SendToSqlGateway {

    fun execute(jobDomain: JobDomain)

}