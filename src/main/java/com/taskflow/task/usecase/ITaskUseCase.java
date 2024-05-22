package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;

import java.util.List;

public interface ITaskUseCase {

    void save(TaskRequest request);

    List<TaskResponse> getAll();
}
