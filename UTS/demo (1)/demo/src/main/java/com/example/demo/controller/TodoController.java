package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Todo;
import com.example.demo.model.User;
import com.example.demo.service.TodoService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listTodos(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElse(null);
        model.addAttribute("todos", todoService.getTodosByUser(user));
        model.addAttribute("username", user.getUsername());
        return "todo-list";
    }

   @GetMapping("/create")
    public String showCreateForm(Model model) {
    model.addAttribute("todo", new Todo());
    return "todo-form";
}

    @PostMapping("/create")
    public String createTodo(@Valid @ModelAttribute("todo") Todo todo,
                             BindingResult result,
                             @AuthenticationPrincipal UserDetails userDetails) {
        if (result.hasErrors()) {
            return "todo-form";
        }

        User user = userService.findByUsername(userDetails.getUsername()).orElse(null);
        todo.setUser(user);
        todoService.save(todo);

        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model,
                               @AuthenticationPrincipal UserDetails userDetails) {
        Todo todo = todoService.getById(id);
        if (todo == null || !todo.getUser().getUsername().equals(userDetails.getUsername())) {
            return "redirect:/todos";
        }
        model.addAttribute("todo", todo);
        return "todo-form";
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable Long id,
                             @Valid @ModelAttribute("todo") Todo todo,
                             BindingResult result,
                             @AuthenticationPrincipal UserDetails userDetails) {
        if (result.hasErrors()) {
            return "todo-form";
        }

        User user = userService.findByUsername(userDetails.getUsername()).orElse(null);
        todo.setUser(user);
        todo.setId(id);
        todoService.save(todo);

        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id,
                             @AuthenticationPrincipal UserDetails userDetails) {
        Todo todo = todoService.getById(id);
        if (todo != null && todo.getUser().getUsername().equals(userDetails.getUsername())) {
            todoService.deleteById(id);
        }
        return "redirect:/todos";
    }
}

