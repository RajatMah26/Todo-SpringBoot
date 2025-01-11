package org.example.springbootlearn;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("anotherTodoService")

public class AnotherTodoService implements TodoService{

    @TimeMonitor

    @Override
    public String doSomething() {
        return "Something from another todo serive";
    }
}
