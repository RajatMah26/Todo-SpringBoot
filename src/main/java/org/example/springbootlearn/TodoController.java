package org.example.springbootlearn;


import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TodoController {

    private  static List<Todo> todos;

    public TodoController(){
        todos=new ArrayList<>();
        todos.add(new Todo(1,false,"Todo1",1));
        todos.add(new Todo(2,true,"Todo1",2));
    }
}
