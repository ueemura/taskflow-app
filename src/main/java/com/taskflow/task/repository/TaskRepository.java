package com.taskflow.task.repository;

import com.taskflow.task.domain.entity.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, Integer> {

}
