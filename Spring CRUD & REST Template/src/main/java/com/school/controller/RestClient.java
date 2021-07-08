package com.school.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import static com.school.service.TodoService.*;

@RequestMapping("/myApi")
public class RestClient {
    public static void main(String[] args){
        callGetAll();
        callGetById();
        callCreateTodo();
        callUpdateTodo();
        callDeleteTodo();
    }
}
