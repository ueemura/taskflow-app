package com.taskflow.task.usecase;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;
import com.taskflow.task.domain.Status;
import com.taskflow.task.domain.Task;

import com.taskflow.task.presenter.ITaskMapper;
import com.taskflow.task.repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    public void save(TaskRequest request) {
        log.info("[TaskUseCase] - Save Task - begin");
        Task task = mapper.toEntity(request);

        task.setStatus(Status.PENDING);
        task.setStartDate(LocalDateTime.now());

        try{
            repository.persistAndFlush(task);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        log.info("[TaskUseCase] - end");
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
}
