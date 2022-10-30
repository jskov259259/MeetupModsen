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
INSERT INTO public.meetup(theme, description, organizer, dateTime, location) VALUES ('Birthday', 'Ivans birthday', 'Ivan', '2019-07-04T13:33:03.969Z', 'Brest');

## Доступные Endpoints
1. Получение списка всех событий GET http://localhost:8080/meetups
2. Получение определенного события по id GET http://localhost:8080/meetups/{id}
3. Регистрация(создание) нового события POST http://localhost:8080/meetup
4. Изменение информации о существующем событии PUT http://localhost:8080/meetup
5. Удаление события DELETE http://localhost:8080/meetups/{id}

