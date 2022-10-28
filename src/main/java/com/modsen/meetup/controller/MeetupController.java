package com.modsen.meetup.controller;

import com.modsen.meetup.model.Meetup;
import com.modsen.meetup.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class MeetupController {

    private MeetupService meetupService;

    @Autowired
    public MeetupController(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    @GetMapping(value = "/meetups")
    public final Collection<Meetup> findAll() {

        return meetupService.findAll();
    }
}
