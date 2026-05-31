package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class TestController {

    // Простое приветствие
    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Jenkins CI/CD!");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }

    // GET запрос с параметром
    @GetMapping("/greet/{name}")
    public Map<String, String> greetUser(@PathVariable String name) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, " + name + "!");
        response.put("status", "success");
        return response;
    }

    // POST запрос (для демонстрации)
    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("received", data);
        response.put("timestamp", LocalDateTime.now());
        response.put("status", "OK");
        return response;
    }

    // GET запрос с параметрами
    @GetMapping("/calculate")
    public Map<String, Integer> calculate(
            @RequestParam int a,
            @RequestParam int b) {
        Map<String, Integer> result = new HashMap<>();
        result.put("sum", a + b);
        result.put("product", a * b);
        result.put("difference", a - b);
        return result;
    }

    // Список пользователей (тестовые данные)
    @GetMapping("/sample-users")
    public List<Map<String, Object>> getUsers() {
        List<Map<String, Object>> users = new ArrayList<>();

        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 1);
        user1.put("name", "John Doe");
        user1.put("email", "john@example.com");

        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 2);
        user2.put("name", "Jane Smith");
        user2.put("email", "jane@example.com");

        users.add(user1);
        users.add(user2);
        return users;
    }
}