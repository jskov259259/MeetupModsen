package com.modsen.meetup.service;

import com.modsen.meetup.dao.MeetupDao;
import com.modsen.meetup.model.Meetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetupServiceImpl implements MeetupService {

    private MeetupDao meetupDao;

    @Autowired
    public MeetupServiceImpl(MeetupDao meetupDao) {
        this.meetupDao = meetupDao;
    }

    @Override
    public List<Meetup> findAll() {
        return meetupDao.findAll();
    }

    @Override
    public Meetup save(Meetup meetup) {
        return meetupDao.save(meetup);
    }

    @Override
    public Meetup findMeetupById(Long id) {
        return meetupDao.findById(id);
    }

    @Override
    public Meetup update(Meetup meetup) {
        return meetupDao.update(meetup);
    }

    @Override
    public Integer delete(Long id) {
        return meetupDao.delete(id);
    }
}
