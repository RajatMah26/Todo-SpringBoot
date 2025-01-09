package org.example.springbootlearn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {


    private TodoService todoService;
    private TodoService todoService2;

    private static List<Todo> todosList;

    private static final String TODO_NOT_FOUND = "Todo not found";



    public TodoController(@Qualifier("FakeTodoService") TodoService todoService,
                          @Qualifier("anotherTodoService") TodoService todoService2) {
        todosList = new ArrayList<>();
        todosList.add(new Todo(1,false,"Todo1",1));
        todosList.add(new Todo(2,true,"Todo1",2));
        this.todoService=todoService;
        this.todoService=todoService2;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(@RequestParam(required=false) Boolean isCompleted){

        System.out.println("Incoming qurey param:"+isCompleted+" "+this.todoService.doSomething());
        // return ResponseEntity.status(HttpStatus.OK).body(todosList);
        return ResponseEntity.ok(todosList);
    }

    @PostMapping
    public ResponseEntity<Todo>  createTodo(@RequestBody Todo newTodo){
        todosList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }


    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoById(@PathVariable Long todoId) {
        for (Todo todo : todosList) {
            if (todo.getId() == todoId) {
                return ResponseEntity.ok(todo);
            }
        }

        // return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
    }

}
