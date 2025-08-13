package com.eventbook.app.repositories;

import com.eventbook.app.models.User;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private static final Map<String, User> BY_EMAIL = new HashMap<>();
    private static final List<User> DATA = new ArrayList<>();
    private static final AtomicInteger ID = new AtomicInteger(1);

    static {
        saveStatic(new User(0, "Admin", "admin@demo.com", "admin123", "ADMIN"));
        saveStatic(new User(0, "Usuario", "user@demo.com", "user123", "USER"));
    }

    private static void saveStatic(User u) {
        if (u.getId() == 0) u.setId(ID.getAndIncrement());
        DATA.add(u);
        if (u.getEmail()!=null) BY_EMAIL.put(u.getEmail(), u);
    }

    public List<User> findAll() { return Collections.unmodifiableList(DATA); }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(BY_EMAIL.get(email));
    }

    public void save(User u) {
        if (u.getId() == 0) u.setId(ID.getAndIncrement());
        DATA.add(u);
        if (u.getEmail()!=null) BY_EMAIL.put(u.getEmail(), u);
    }

    public int nextId() { return ID.getAndIncrement(); }
}
