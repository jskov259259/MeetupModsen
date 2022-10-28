package com.modsen.meetup.dao;

import com.modsen.meetup.config.TestConfig;
import com.modsen.meetup.model.Meetup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({MeetupDaoImpl.class})
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@Rollback
@ActiveProfiles("dev")
@EnableAutoConfiguration
class MeetupDaoImplTestIT {

    private MeetupDaoImpl meetupDao;

    @Autowired
    public MeetupDaoImplTestIT(MeetupDaoImpl meetupDao) {
        this.meetupDao = meetupDao;
    }

    @Test
    void testFindAll() {

    }

    @Test
    void testSave() {
        assertNotNull(meetupDao);
        int sizeBefore = meetupDao.findAll().size();
        Meetup meetup = createMeetup();
        meetupDao.save(meetup);
        assertEquals(sizeBefore, meetupDao.findAll().size() - 1);
    }

    private Meetup createMeetup() {
        return new Meetup("Test theme", "Test description", "Test organizer", LocalDateTime.now(), "Test location");
    }

}