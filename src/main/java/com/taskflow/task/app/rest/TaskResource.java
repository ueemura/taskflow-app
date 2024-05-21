package com.taskflow.task.app.rest;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.usecase.ITaskUseCase;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/task")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    ITaskUseCase useCase;

    @POST
    @Transactional
    public Response saveTask(TaskRequest request){
        log.info("[TaskResource] request: {}", request);
        useCase.save(request);
        return Response.status(Response.Status.CREATED).build();
    }
}
