package com.modsen.meetup.dao;

import com.modsen.meetup.model.Meetup;

import java.util.List;
import java.util.Map;

public interface MeetupDao {

    List<Meetup> findAll();
    List<Meetup> findAllWithFilter(String query, Map<String, String> params);
    Meetup findById(Long id);
    Meetup save(Meetup meetup);
    Meetup update(Meetup meetup);
    void delete(Long id);
}
