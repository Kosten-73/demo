package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> userStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UserService() {
        // Добавляем тестовые данные
        createUser(new User(null, "Alice", "alice@test.com"));
        createUser(new User(null, "Bob", "bob@test.com"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public User createUser(User user) {
        Long id = idGenerator.getAndIncrement();
        User newUser = new User(id, user.getName(), user.getEmail());
        userStore.put(id, newUser);
        return newUser;
    }

    public Optional<User> updateUser(Long id, User user) {
        if (userStore.containsKey(id)) {
            User updatedUser = new User(id, user.getName(), user.getEmail());
            userStore.put(id, updatedUser);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        return userStore.remove(id) != null;
    }
}