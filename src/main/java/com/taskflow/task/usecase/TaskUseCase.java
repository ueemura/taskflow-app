package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class TaskUseCase implements ITaskUseCase {
    @Override
    public void saveTask(TaskRequest request) {

    }
}
