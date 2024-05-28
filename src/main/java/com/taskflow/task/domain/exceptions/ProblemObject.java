package com.taskflow.task.domain.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProblemObject {

    private String name;
    private String message;

}
