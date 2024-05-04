package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class EntryController {

    private TodoRepository todoRepository;

    public EntryController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(value = "/fetchToDos", method = RequestMethod.GET)
    ResponseEntity<?> todos() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(todos);
    }

    @RequestMapping(value = "/addToDo", method = RequestMethod.GET)
    ResponseEntity<?> todos(@RequestParam String msg) {
        Todo todo = new Todo();
        todo.setId(new Random().nextLong(10000000));
        todo.setMsg(msg);
        todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Saved");
    }
}
