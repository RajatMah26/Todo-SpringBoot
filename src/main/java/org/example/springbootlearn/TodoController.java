package org.example.springbootlearn;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TodoController {

    private  static List<Todo> todosList;

    public TodoController(){
        todosList=new ArrayList<>();
        todosList.add(new Todo(1,false,"Todo1",1));
        todosList.add(new Todo(2,true,"Todo1",2));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
       // return ResponseEntity.status(HttpStatus.OK).body(todosList);
        return ResponseEntity.ok(todosList);
    }


    // @ResponseStatus(HttpStatus.CREATED) we can use for status annotaions to update

    @PostMapping("/todos")
    public ResponseEntity<Todo>  createTodo(@RequestBody Todo newTodo){
            todosList.add(newTodo);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }




}
