package com.eventbook.app.models;

import java.time.LocalDate;

public class Event {
    private int id;
    private String name;
    private LocalDate date;
    private String location;

    public Event() {}
    public Event(int id, String name, LocalDate date, String location) {
        this.id=id; this.name=name; this.date=date; this.location=location;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
