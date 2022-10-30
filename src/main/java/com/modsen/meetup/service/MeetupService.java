package com.modsen.meetup.service;

import com.modsen.meetup.model.Meetup;

import java.util.List;
import java.util.Map;

public interface MeetupService {

    List<Meetup> findAll(Map<String,String> filterParams);

    Meetup save(Meetup meetup);

    Meetup findMeetupById(Long id);

    Meetup update(Meetup meetup);

    void delete(Long id);
}
