package com.marvin.dale.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping("/todos/add")
    public void addTodo(@RequestBody Todo todo) {
        repository.save(todo);
    }

    @CrossOrigin
    @DeleteMapping("/todos/delete/{id}")
    public void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @CrossOrigin
    @PutMapping("todos/complete/{id}")
    public void completeTodo(@PathVariable Long id) {
        repository.findById(id).map(todo -> {
            todo.setComplete(true);
            return repository.save(todo);
        });
    }
}
