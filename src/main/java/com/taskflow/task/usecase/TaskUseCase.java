package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;
import com.taskflow.task.app.dto.TaskUpdateRequest;
import com.taskflow.task.domain.entity.Task;
import com.taskflow.task.domain.enumeration.Status;
import com.taskflow.task.domain.exceptions.BusinessException;
import com.taskflow.task.presenter.ITaskMapper;
import com.taskflow.task.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ApplicationScoped
public class TaskUseCase implements ITaskUseCase {

    @Inject
    ITaskMapper mapper;

    @Inject
    TaskRepository repository;


    @Override
    public Task getById(Integer id) throws Exception {
        Task foundTask = repository.findById(id);

        if (foundTask == null) {
            throw new BusinessException("Task not found");
        }

        return foundTask;
    }

    @Override
    public List<TaskResponse> getAll() {
        log.info("[TaskUseCase] - Get All Tasks");

        List<TaskResponse> taskResponseList = new ArrayList<>();

        repository.listAll().forEach(task ->
                taskResponseList.add(mapper.toResponse(task))
        );
        return taskResponseList;
    }

    @Override
    @Transactional
    public void save(TaskRequest request) throws Exception {
        log.info("[TaskUseCase] - Save Task - begin");
        Task task = mapper.toEntity(request);

        task.setStatus(Status.PENDING);
        task.setStartDate(LocalDateTime.now());

        try {
            repository.persistAndFlush(task);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

        log.info("[TaskUseCase] - end");
    }

    @Override
    @Transactional
    public void update(Integer id, TaskUpdateRequest request) throws Exception {
        log.info("[TaskUseCase] - Update Task Description");
        Task task = getById(id);
        task.setDescription(mapper.toEntity(request).getDescription());

        try {
            repository.persistAndFlush(task);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void updateTaskStatus(Integer id) throws Exception {
        Task task = getById(id);
        task.setStatus(Status.DONE);
        task.setEndDate(LocalDateTime.now());

        try {
            repository.persistAndFlush(task);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) throws Exception {
        Task foundTask = getById(id);

        try {
            repository.delete(foundTask);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }
}
