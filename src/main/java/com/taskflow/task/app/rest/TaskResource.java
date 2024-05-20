package com.taskflow.task.app.rest;

import com.taskflow.task.app.dto.TaskRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @POST
    public Response saveTask(TaskRequest request){
//        taskUseCase.saveTask(request);
        return null;
    }
}
