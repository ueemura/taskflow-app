package com.taskflow.task.domain.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.ConstraintViolationException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String title;
    private String detail;
    private List<ProblemObject> messages;

    public Problem(ConstraintViolationException e){
        this.status = 400;
        this.timestamp = OffsetDateTime.now();
        this.title = "Invalid data";
        this.detail = "Invalid data";
        this.messages = new ArrayList<>();
    }

    public Problem(BusinessException e){
        this.status = 422;
        this.timestamp = OffsetDateTime.now();
        this.title = "Business";
        this.detail = e.getLocalizedMessage();
    }
}
