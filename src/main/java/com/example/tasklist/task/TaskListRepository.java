package com.example.tasklist.task;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskListRepository {
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Autowired
  public TaskListRepository(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  List<TaskList> getAllTaskLists() {
    return namedParameterJdbcTemplate.query("SELECT * FROM TASK_LIST;", new MapSqlParameterSource(),
        (rs, rowNum) -> new TaskList(rs.getInt("id"), rs.getString("title"),
            getAllTasksForAList(rs.getInt("id"))));
  }

  List<Task> getAllTasksForAList(int listId) {
    return namedParameterJdbcTemplate.query("SELECT * FROM TASK WHERE list_id=:listId;",
        new MapSqlParameterSource("listId", listId),
        (rs, rowNum) -> new Task(rs.getString("task"), rs.getBoolean("complete")));
  }
}
