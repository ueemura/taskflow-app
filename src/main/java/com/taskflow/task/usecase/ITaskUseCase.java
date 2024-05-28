package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;
import com.taskflow.task.app.dto.TaskUpdateRequest;
import com.taskflow.task.domain.entity.Task;

import java.util.List;

public interface ITaskUseCase {

    Task getById(Integer id) throws Exception;

    List<TaskResponse> getAll();

    void save(TaskRequest request) throws Exception;

    void update(Integer id, TaskUpdateRequest request) throws Exception;

    void updateTaskStatus(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
