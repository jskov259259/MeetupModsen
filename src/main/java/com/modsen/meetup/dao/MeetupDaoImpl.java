package com.modsen.meetup.dao;

import com.modsen.meetup.model.Meetup;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class MeetupDaoImpl implements MeetupDao {

    private SessionFactory sessionFactory;

    @Autowired
    public MeetupDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Meetup> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Meetup m").list();
    }


    @Override
    public Meetup findById(Long id) {
        return null;
    }

    @Override
    public Meetup save(Meetup meetup) {
        return null;
    }

    @Override
    public Meetup update(Meetup meetup) {
        return null;
    }

    @Override
    public void delete(Meetup meetup) {

    }
}
