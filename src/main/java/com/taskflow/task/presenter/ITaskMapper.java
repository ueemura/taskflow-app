package com.taskflow.task.presenter;

import com.taskflow.task.app.dto.TaskRequest;
import com.taskflow.task.app.dto.TaskResponse;
import com.taskflow.task.app.dto.TaskUpdateRequest;
import com.taskflow.task.domain.enumeration.Status;
import com.taskflow.task.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "jakarta-cdi")
public interface ITaskMapper {

    @Mapping(target = "description", source = "description")
    Task toEntity(TaskRequest request);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "status", source = "status", qualifiedByName = "enumToString")
    @Mapping(target = "id", source = "id")
    TaskResponse toResponse(Task task);

    @Mapping(target = "description", source = "description")
    Task toEntity(TaskUpdateRequest request);

    @Named("enumToString")
    default String enumToString(Status status){
        return status != null ? status.toString() : null;
    }
}
