package org.example.springbootlearn;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("FakeTodoService")
public class FakeTodoService implements TodoService{


    public String doSomething(){
        return "do something";
    }
}
