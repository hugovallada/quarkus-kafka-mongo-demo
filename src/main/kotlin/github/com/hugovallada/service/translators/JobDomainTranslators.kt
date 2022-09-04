package github.com.hugovallada.service.translators

import github.com.hugovallada.domain.entity.JobDomain
import github.com.hugovallada.service.dto.JobRequest
import github.com.hugovallada.service.dto.JobResponse
import github.com.hugovallada.service.gateway.db.mongo.model.JobDocument
import github.com.hugovallada.service.gateway.db.postgres.model.Job

fun JobRequest.toJobDomain() = JobDomain(
    name = this.name, salary = this.salary, contractMonths = this.monthsOfContract
)

fun JobDomain.toJobDocument() = JobDocument(
    name, salary, contractMonths
)

fun JobDomain.toJobResponse() = JobResponse(
    name = this.name, salary = this.salary, monthsOfContract = this.contractMonths, fulfilled = this.fulfilled
)

fun JobDocument.toJobDomain() = JobDomain(
    name = this.name, salary = this.salary, contractMonths = this.monthsContract, fulfilled = this.fulfilled
)

fun JobDomain.toJob() = Job(
    id = this.id ?: throw Exception(""), name = this.name, salary = this.salary, monthsContract = this.contractMonths, fulfilled = this.fulfilled
)

fun Job.toJobDomain() = JobDomain(
    name = this.name, salary = this.salary, contractMonths = this.monthsContract, fulfilled = this.fulfilled
)