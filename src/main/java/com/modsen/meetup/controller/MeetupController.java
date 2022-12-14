package com.modsen.meetup.controller;

import com.modsen.meetup.model.Meetup;
import com.modsen.meetup.service.MeetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@CrossOrigin
public class MeetupController {

    private MeetupService meetupService;

    @Autowired
    public MeetupController(MeetupService meetupService) {
        this.meetupService = meetupService;
    }

    @GetMapping(value = "/meetups")
    public final Collection<Meetup> findAll(@RequestParam(required=false) Map<String,String> filterParams) {

        return meetupService.findAll(filterParams);
    }

    @PostMapping(value = "/meetup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Meetup> saveMeetup(@RequestBody Meetup meetup) {

        Meetup newMeetup = meetupService.save(meetup);
        return new ResponseEntity<>(newMeetup, HttpStatus.CREATED);
    }

    @GetMapping(value = "/meetups/{id}")
    public Meetup findMeetupById(@PathVariable Long id) {

        return meetupService.findMeetupById(id);
    }

    @PutMapping(value = "/meetup", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Meetup> updateMeetup(@RequestBody Meetup meetup) {

        Meetup updatedMeetup = meetupService.update(meetup);
        return new ResponseEntity<>(updatedMeetup, HttpStatus.OK);
    }

    @DeleteMapping(value = "/meetups/{id}")
    public ResponseEntity<Integer> deleteMeetup(@PathVariable Long id) {
        meetupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
