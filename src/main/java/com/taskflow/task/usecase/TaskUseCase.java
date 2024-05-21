package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.domain.Status;
import com.taskflow.task.domain.Task;

import com.taskflow.task.presenter.ITaskMapper;
import com.taskflow.task.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@ApplicationScoped
public class TaskUseCase implements ITaskUseCase {

    @Inject
    ITaskMapper mapper;

    @Inject
    TaskRepository repository;

    @Override
    public void save(TaskRequest request) {
        log.info("[TaskUseCase] - begin");
        Task task = mapper.toEntity(request);

        task.setStatus(Status.PENDING);
        task.setStartDate(LocalDateTime.now());

        repository.persistAndFlush(task);
        log.info("[TaskUseCase] - end");
    }
}
