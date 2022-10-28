package com.modsen.meetup.service;

import com.modsen.meetup.model.Meetup;

import java.util.List;

public interface MeetupService {

    List<Meetup> findAll();

    Meetup save(Meetup meetup);
}
