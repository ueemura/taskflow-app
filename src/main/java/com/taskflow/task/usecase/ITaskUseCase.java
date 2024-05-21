package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;

public interface ITaskUseCase {

    void save(TaskRequest request);
}
