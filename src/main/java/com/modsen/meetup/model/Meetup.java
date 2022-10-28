package com.modsen.meetup.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meetup")
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "description")
    private String description;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "location")
    private String location;

    public Meetup(String test_theme, String test_description, String test_organizer, LocalDateTime now, String test_location) {
    }

    public Meetup(long id, String theme, String description, String organizer, LocalDateTime dateTime, String location) {
        this.id = id;
        this.theme = theme;
        this.description = description;
        this.organizer = organizer;
        this.dateTime = dateTime;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Meetup{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", organizer='" + organizer + '\'' +
                ", dateTime=" + dateTime +
                ", location='" + location + '\'' +
                '}';
    }
}
