package com.modsen.meetup.service;

import com.modsen.meetup.dao.MeetupDao;
import com.modsen.meetup.model.Meetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MeetupServiceImpl implements MeetupService {

    private MeetupDao meetupDao;

    @Autowired
    public MeetupServiceImpl(MeetupDao meetupDao) {
        this.meetupDao = meetupDao;
    }

    @Override
    public List<Meetup> findAll(Map<String, String> filterParams) {
        if (filterParams.size() == 0) {
            return meetupDao.findAll();
        } else return findAllWithFilter(filterParams);
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
    public void delete(Long id) {
        meetupDao.delete(id);
    }

    private List<Meetup> findAllWithFilter(Map<String, String> filterParams) {

        checkParams(filterParams);
        String query = createQuery(filterParams);
        System.out.println(query);
        return meetupDao.findAllWithFilter(query, filterParams);
    }

    private String createQuery(Map<String, String> filterParams) {
        StringBuilder builder = new StringBuilder("from Meetup m ");
        int counter = 0;
            for (Map.Entry<String, String> entry : filterParams.entrySet()) {
                if (counter == 0) {
                    builder.append("where " + entry.getKey() + "=:" + entry.getKey());
                    counter++;
                }
                if (filterParams.size() == 1) return builder.toString();
                builder.append(" AND " + entry.getKey() + "=:" + entry.getKey());

            }
        return builder.toString();
    }

    private void checkParams(Map<String, String> filterParams) {
        for (String key : filterParams.keySet()) {
            if (!(key.equals("theme") || (key.equals("organizer")) || (key.equals("dateTime")))) {
                throw new RuntimeException("Incorrect query params");
            }
        }

    }
}


