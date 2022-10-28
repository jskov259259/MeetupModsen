DROP TABLE IF EXISTS meetup;

CREATE TABLE meetup
(
    id INT NOT NULL,
    theme varchar(30),
    description varchar(30),
    organizer varchar(30),
    dateTime timestamp,
    location varchar(30),
    CONSTRAINT meetup_pk PRIMARY KEY (id)
);

