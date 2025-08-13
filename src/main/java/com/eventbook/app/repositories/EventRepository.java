package com.eventbook.app.repositories;

import com.eventbook.app.models.Event;
import java.util.*;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class EventRepository {
    private static final List<Event> DATA = new ArrayList<>();
    private static final AtomicInteger ID = new AtomicInteger(1000);

    static {
        DATA.add(new Event(ID.incrementAndGet(), "Hackathon", LocalDate.now().plusDays(7), "Auditorio A"));
        DATA.add(new Event(ID.incrementAndGet(), "Meetup Java", LocalDate.now().plusDays(14), "Sala 3"));
    }

    public List<Event> findAll() { return Collections.unmodifiableList(DATA); }

    public void save(Event e) {
        if (e.getId() == 0) e.setId(ID.incrementAndGet());
        DATA.add(e);
    }

    public void deleteById(int id) {
        DATA.removeIf(ev -> ev.getId() == id);
    }

    public int nextId() { return ID.getAndIncrement(); }
}
