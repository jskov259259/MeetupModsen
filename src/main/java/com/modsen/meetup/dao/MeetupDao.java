package com.modsen.meetup.dao;

import com.modsen.meetup.model.Meetup;

import java.util.List;

public interface MeetupDao {

    List<Meetup> findAll();
    Meetup findById(Long id);
    Meetup save(Meetup meetup);
    Meetup update(Meetup meetup);
    void delete(Meetup meetup);
}
