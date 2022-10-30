package com.modsen.meetup.dao;

import com.modsen.meetup.model.Meetup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class MeetupDaoImpl implements MeetupDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Meetup> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Meetup m").list();
    }

    @Override
    public List<Meetup> findAllWithFilter(String query, Map<String, String> params) {
        return sessionFactory.getCurrentSession()
                .createQuery(query).setProperties(params).list();
    }

    @Override
    public Meetup findById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Meetup.class, id);
    }

    @Override
    public Meetup save(Meetup meetup) {
        sessionFactory.getCurrentSession().saveOrUpdate(meetup);
        return meetup;
    }

    @Override
    public Meetup update(Meetup meetup) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Meetup oldMeetup = findById(meetup.getId());
        updateMeetup(oldMeetup, meetup);
        session.update(oldMeetup);
        tx.commit();
        return oldMeetup;
    }

    @Override
    public void delete(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Meetup meetup = findById(id);
        session.delete(meetup);
        tx.commit();

    }

    private void updateMeetup(Meetup oldMeetup, Meetup newMeetup) {
        oldMeetup.setTheme(newMeetup.getTheme());
        oldMeetup.setDescription(newMeetup.getDescription());
        oldMeetup.setOrganizer(newMeetup.getOrganizer());
        oldMeetup.setDateTime(newMeetup.getDateTime());
        oldMeetup.setLocation(newMeetup.getLocation());
    }

}
