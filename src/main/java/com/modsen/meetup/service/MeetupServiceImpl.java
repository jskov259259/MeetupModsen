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
}
