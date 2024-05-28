package com.taskflow.task.app.rest;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskUpdateRequest;
import com.taskflow.task.usecase.ITaskUseCase;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/tasks")
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    ITaskUseCase useCase;

    @GET
    public Response getAllTask(){
        log.info("[TaskResource] - Get All Tasks");
        return Response.ok(useCase.getAll()).build();
    }

    @POST
    public Response saveTask(@Valid TaskRequest request) throws Exception {
        log.info("[TaskResource] - Save New Task - request: {}", request);
        useCase.save(request);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{taskId}")
    public Response updateTask(@PathParam("taskId") Integer id, TaskUpdateRequest request) throws Exception {
        useCase.update(id, request);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{taskId}/complete")
    public Response markTaskAsComplete(@PathParam("taskId") Integer id) throws Exception {

            useCase.updateTaskStatus(id);
            return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{taskId}")
    public Response deleteTask(@PathParam("taskId") Integer id) throws Exception {
        useCase.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}
