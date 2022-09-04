package github.com.hugovallada.service.controller

import github.com.hugovallada.domain.usecase.GetJobUseCase
import github.com.hugovallada.domain.usecase.SaveJobUseCase
import github.com.hugovallada.service.dto.JobRequest
import github.com.hugovallada.service.translators.toJobDomain
import github.com.hugovallada.service.translators.toJobResponse
import org.jboss.logging.Logger
import org.jboss.logging.annotations.Param
import org.jboss.resteasy.reactive.RestResponse
import java.net.URI
import javax.annotation.Resource
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Resource
@Path("/jobs")
class JobController(private val log: Logger, private val jobUseCase: SaveJobUseCase, private val getJobUseCase: GetJobUseCase) {


    @POST
    fun createNewJob(@Valid jobRequest: JobRequest): RestResponse<Any> {
        log.info(jobRequest)
        with(jobUseCase.execute(jobRequest.toJobDomain())) {
            log.info("Finalized")
            return RestResponse.created(URI.create("/jobs/$this"))
        }
    }

    @GET
    @Path("/{id}")
    fun getJob(@Param id: String): RestResponse<Any> {
        log.info(id)
        with(getJobUseCase.execute(id)) {
            return RestResponse.ok(toJobResponse().also { log.info(it) })
        }
    }
}