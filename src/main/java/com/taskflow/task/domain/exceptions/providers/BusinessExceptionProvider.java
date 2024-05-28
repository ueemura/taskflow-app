package com.taskflow.task.domain.exceptions.providers;

import com.taskflow.task.domain.exceptions.BusinessException;
import com.taskflow.task.domain.exceptions.Problem;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionProvider implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        Problem problem = new Problem(e);
        return Response.status(422).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }
}
