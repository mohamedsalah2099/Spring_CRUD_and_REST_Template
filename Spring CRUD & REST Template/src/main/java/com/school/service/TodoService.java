package com.school.service;

import com.school.model.School;
import com.school.model.Todos;
import com.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TodoService {
    private static final String URL = "https://jsonplaceholder.typicode.com/todos";
    private static final String URL_ID = "https://jsonplaceholder.typicode.com/todos/1";
    private static final String URL_POST = "https://jsonplaceholder.typicode.com/todos/";
    private static final String URL_UPDATE_OR_DELETE = "https://jsonplaceholder.typicode.com/todos/1";

    static RestTemplate restTemplate = new RestTemplate();

    public static void callGetAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameter", headers);
        ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
        System.out.println(result);
    }

    public static void callGetById(){
        Map<String,Integer> param = new HashMap<>();
        param.put("userId", 10);
        Todos todos = restTemplate.getForObject(URL_ID, Todos.class,param);
        System.out.println("ID : " + todos.getId());
        System.out.println("Title : " + todos.getTitle());
    }

    public static void callCreateTodo(){
        Todos todos = new Todos(100,100,"My Own Post",true);
        ResponseEntity<Todos> todos_response = restTemplate.postForEntity(URL_POST, todos, Todos.class);
        System.out.println(todos_response.getStatusCode());
    }

    public static void callUpdateTodo(){
        Map<String,Integer> param = new HashMap<>();
        param.put("id", 20);
        Todos updateTodos = new Todos(100,100,"My Own Post - Update",true);
        restTemplate.put(URL_UPDATE_OR_DELETE, updateTodos, param);
    }

    public static void callDeleteTodo(){
        Map<String,Integer> param = new HashMap<>();
        param.put("id", 45);
        restTemplate.put(URL_UPDATE_OR_DELETE, param);
    }

}
