package com.taskflow.task.domain.exceptions.providers;

import com.taskflow.task.domain.exceptions.Problem;
import com.taskflow.task.domain.exceptions.ProblemObject;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Iterator;

@Provider
public class ConstraintViolationExceptionProvider implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        Problem problem = new Problem(e);

        e.getConstraintViolations().forEach(c -> problem.getMessages()
                .add(new ProblemObject(lastFieldName(c.getPropertyPath().iterator()), c.getMessage())));

        return Response.status(Response.Status.BAD_REQUEST).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }

    private String lastFieldName(Iterator<Path.Node> nodes) {
        Path.Node last = null;
        while(nodes.hasNext()){
            last = nodes.next();
        }
        return last.getName();
    }
}
