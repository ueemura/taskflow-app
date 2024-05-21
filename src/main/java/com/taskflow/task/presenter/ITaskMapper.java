package com.taskflow.task.presenter;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.domain.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jakarta-cdi")
public interface ITaskMapper {

    @Mapping(target = "description", source = "description")
    Task toEntity(TaskRequest request);
}
