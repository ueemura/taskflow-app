package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;
import com.taskflow.task.app.dto.TaskUpdateRequest;

import java.util.List;

public interface ITaskUseCase {

    List<TaskResponse> getAll();

    void save(TaskRequest request);

    void update(Integer id, TaskUpdateRequest request);

    void updateTaskStatus(Integer id);
}
