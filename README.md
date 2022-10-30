# Modsen Meetup API
Вступительная задача для стажировки по направлению Java.

## Описание
CRUD Rest API приложение для работы с мероприятиями (создание, изменение, удаление, получение)

## Технологии
* JDK 11
* Apache Maven
* Git
* Spring Boot
* Hibernate
* PostgreSQL

## Инструкция по запуску
#### Скачать проект из репозитория
git clone https://github.com/jskov259259/MeetupModsen.git
#### Установить проект, запустив команду:
mvn clean install
#### Запустить REST-приложение на порту 8080
java -jar target/meetup-0.0.1-SNAPSHOT.war

## Инициализация БД
#### Создать базу данных в PostgreSQL. 
#### Создать таблицу meetup
CREATE TABLE public.meetup
(
    id SERIAL PRIMARY KEY NOT NULL,
    theme TEXT,
    description TEXT,
	organizer TEXT,
    dateTime timestamp,
	location TEXT
);
#### Заполнить таблицу тестовыми данными
1. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Birthday', 'Ivans birthday', 'Ivan', '2019-07-04T13:33:03.969Z', 'Brest');
2. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Birthday', 'Kate birthday', 'Kate', '2019-08-04T13:33:03.969Z', 'Brest');
3. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('New Year', 'New year event', 'Oleg', '2020-12-31T20:00:00.969Z', 'Minsk');
4. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Easter', 'Easter party', 'Ivan', '2021-04-04T20:00:00.969Z', 'Grodno');
5. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Easter', 'Easter party', 'Oleg', '2021-04-04T20:00:00.969Z', 'Minsk');
6. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('New Year', 'New year event', 'Kate', '2021-12-31T20:00:00.969Z', 'Grodno');
7. INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Birthday', 'Oleg birthday', 'Oleg', '2022-08-05T14:00:00.969Z', 'Minsk');

## Доступные Endpoints
1. Получение списка всех событий GET http://localhost:8080/meetups
2. Получение определенного события по id GET http://localhost:8080/meetups/{id}
3. Регистрация(создание) нового события POST http://localhost:8080/meetup
4. Изменение информации о существующем событии PUT http://localhost:8080/meetup
5. Удаление события DELETE http://localhost:8080/meetups/{id}

## Пример работы в Postman
1. GET http://localhost:8080/meetups
![image](https://user-images.githubusercontent.com/79707407/198869275-500113c4-7964-4453-8417-afbad7f7177e.png)
2. GET http://localhost:8080/meetups/2
![image](https://user-images.githubusercontent.com/79707407/198869350-e6d7bf92-9e9c-4e6b-aa6e-1abf0543bcfc.png)
3. POST http://localhost:8080/meetup
![image](https://user-images.githubusercontent.com/79707407/198869406-762f3ec1-0a81-4cdc-ac8d-105f2a69950e.png)
4. PUT http://localhost:8080/meetup
![image](https://user-images.githubusercontent.com/79707407/198869459-1b82e9c0-de04-444a-8884-91e1c04c7529.png)
5. DELETE http://localhost:8080/meetups/28
![image](https://user-images.githubusercontent.com/79707407/198869556-0c2ea2ae-224b-430d-8050-24d69f517644.png)


