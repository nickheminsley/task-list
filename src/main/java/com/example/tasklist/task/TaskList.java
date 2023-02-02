package com.example.tasklist.task;

import java.util.List;

public record TaskList(int id, String title, List<Task> taskList) {}
