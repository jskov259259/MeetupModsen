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
#### Создать базу данных в СУБД PostgreSQL (в приложении используется БД с названием modsen) 
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
![image](https://user-images.githubusercontent.com/79707407/198870680-b604f489-b5da-41e6-9ce2-8435e45c5c2c.png)

Test Event сохранен с id 8
![image](https://user-images.githubusercontent.com/79707407/198870632-0390be66-261a-42c7-aefb-62024fc12ec8.png)

4. PUT http://localhost:8080/meetup
![image](https://user-images.githubusercontent.com/79707407/198870771-8ff735f7-666e-4ffc-8cb9-6dc2518b7fc1.png)

Meetup с id 8 изменен
![image](https://user-images.githubusercontent.com/79707407/198870800-7a67c73d-2cf0-4e8c-bc01-7a9d6a036e5a.png)

5. DELETE http://localhost:8080/meetups/8
![image](https://user-images.githubusercontent.com/79707407/198870832-0d043649-a6fe-4391-83a9-4754a9823382.png)

Meetup с id 8 удален
![image](https://user-images.githubusercontent.com/79707407/198870862-cd193f84-92d8-49b1-a995-4e0fa7c9a954.png)


## Дополнительные задания
#### Чувствительные к окружению значения вынесены в файл application.properties <br/>
server.port - порт для запуска сервера. <br/>
<br/>
postgresql_driver - описание класса драйвера <br/>
postgresql_url - url базы данных <br/>
postgresql_username - имя пользователя <br/>
postgresql_password - пароль <br/>

#### Возможность фильтрации событий при получение списка
Для этого в url указываются дополнительные параметры: GET http://localhost:8080/meetups?param1=value&param2=value <br/>
Фильтровать можно только по полям theme, organizer, dateTime. При использование других параметров генерируется RuntimeException <br/>
Пример: GET http://localhost:8080/meetups?theme=Birthday&organizer=Ivan <br/>
![image](https://user-images.githubusercontent.com/79707407/198875802-7ab4f26b-ce40-4596-9414-d1417af282d7.png)
