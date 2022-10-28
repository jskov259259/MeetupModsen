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

        Query query = sessionFactory.getCurrentSession().createQuery("update Meetup set theme = :theme, description = :description" +
                ", organizer = :organizer" +
                ", dateTime = :dateTime" +
                ", location = :location" +
                " where id = :id");

        query.setParameter("theme", meetup.getTheme());
        query.setParameter("description", meetup.getDescription());
        query.setParameter("organizer", meetup.getOrganizer() );
        query.setParameter("dateTime", meetup.getDateTime() );
        query.setParameter("location", meetup.getLocation() );
        query.setParameter("id", meetup.getId());

        int result = query.executeUpdate();
        tx.commit();
        return meetup;
    }

    @Override
    public Integer delete(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query =  session.createQuery("delete Meetup where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        tx.commit();
        return result;
    }

}
