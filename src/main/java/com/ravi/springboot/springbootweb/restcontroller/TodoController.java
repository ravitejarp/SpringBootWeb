package com.ravi.springboot.springbootweb.restcontroller;

import com.ravi.springboot.springbootweb.model.Todo;
import com.ravi.springboot.springbootweb.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos-list")
    public String login(ModelMap modelMap) {
        modelMap.put("todos", todoService.fetchTodos(modelMap.get("name").toString()));
        return "todo";
    }

    @GetMapping("/addTodo")
    public String showAddTodo(ModelMap modelMap) {
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(ModelMap modelMap, @RequestParam String desc) {
        todoService.addTodo(modelMap.get("name").toString(), desc);
        return "redirect:/todos-list";
    }


}
