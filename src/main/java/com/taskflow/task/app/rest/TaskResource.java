package com.taskflow.task.app.rest;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.usecase.ITaskUseCase;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
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
        log.info("[TaskResource] - Save New Task - request: {}", request);
        useCase.save(request);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getAllTask(){
        log.info("[TaskResource] - Get All Tasks");
        return Response.ok(useCase.getAll()).build();
    }
}
