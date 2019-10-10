package com.ravi.springboot.springbootweb.service;

import com.ravi.springboot.springbootweb.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todoList.add(new Todo(1, "ravi", "Spring MVC", new Date(), false));
        todoList.add(new Todo(2, "ravi", "Spring web", new Date(), false));
        todoList.add(new Todo(3, "ravi", "Spring boot", new Date(), false));
    }

    public List<Todo> fetchTodos(String user) {
        List<Todo> todoListForUser = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                todoListForUser.add(todo);
            }
        }
        return todoListForUser;
    }

    public void addTodo(String user, String desc) {
        todoList.add(new Todo(++todoCount, user, desc, new Date(), false));
    }

    public void deleteTodo(int id) {
        todoList.removeIf(todo -> todo.getId() == id);
    }
}
