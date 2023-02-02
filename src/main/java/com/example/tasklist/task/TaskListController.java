package com.example.tasklist.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/task/list")
public class TaskListController {

  TaskListRepository taskListRepository;

  @Autowired
  public TaskListController(final TaskListRepository taskListRepository) {
    this.taskListRepository = taskListRepository;
  }

  @GetMapping("/all")
  List<TaskList> getALlTaskLists(){
    return taskListRepository.getAllTaskLists();
  }
}
