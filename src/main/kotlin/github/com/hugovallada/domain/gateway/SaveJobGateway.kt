package github.com.hugovallada.domain.gateway

import github.com.hugovallada.domain.entity.JobDomain

interface SaveJobGateway {
    fun save(job: JobDomain): String
}