package com.modsen.meetup.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meetup")
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "description")
    private String description;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "dateTime")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    @Column(name = "location")
    private String location;

    public Meetup() {
    }

    public Meetup(Long id, String theme, String description, String organizer, LocalDateTime dateTime, String location) {
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

    public void setId(Long id) {
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
