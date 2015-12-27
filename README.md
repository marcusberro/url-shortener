# url-shortener
This is an URL Shortener written in Java 8, Spring Boot, Spring MVC, Spring Data JPA and H2DB

- Generate a hexa code based url
- Save information related to redirections: user-agent, source-host, requets-date...
- List all available shorten urls

### Usage & Installation

Under construction version: it's better run it in idea IDE with Gradle plugin

There are 2 database options: mysql or h2 in memory. To run with a specific db inform spring.profiles.active property calling gradle:

> gradle bootRun -Pspring.profiles.active=mysql

or

> gradle bootRun -Pspring.profiles.active=h2

If it doesn't find this property, default property is h2

Once you start the application, the following endpoints are available so far:

Home (Future single-page app)
```
[GET] http://localhost:8080
```

Shorten url
```
[POST] http://localhost:8080
{url-to-be-shortened-in-body}
```


List all shorten urls
```
[GET] http://localhost:8080/shorten-urls
```

Redirects url
```
[GET] http://localhost:8080/{code}
```

H2 Console (if you need to check in-memory database content)
```
[GET] http://localhost:8080/h2-console/
```


To be continued...

### Development

Project Details

- REST based API
- Single Jar Application
- Embedded Application server Undertown
- In-memory H2 and Mysql Relational Databases using Gradle and Spring profiles
- Springboot schema.sql and data.sql auto running

### Tech

Url Sortener uses a number of open source projects to work properly:

* [Spring-MVC] - Awesome REST support
* [Spring-Boot] - Good way to start working with Microservices architecture
* [Spring-Data-JPA] - Helps reaching different Relational DBs
* [Hibernate] - Guess you know it
* [H2DB] - Lightweight in-memory and persistent database
* [Embedded-Tomcat-8] - Great servlet container

### Future Releases

- Improve url code generation (choose an algoritm)
- Url validation before shorten
- Single-page application frontend


### Todos/Enhancements

Strong desirable:
- Dockerize
- Refactor Spring and gradle build Profile integration
- Tuning: undertown and HikariCP
- Support for other Embedded Application server options (Tomcat/Jetty)
- Multiple Relational Database support: Mysql and H2 supported, Postgres needed
- Generate tables with ddl scripts: springboot database initialization supported, Flyway integration needed
- Light footprint, can run on very constrained systems

Maybe, someday...
- Refuses abusive Phishing and Malware Urls
- Actively scans short Urls to identify possible threats


   [Spring-MVC]: <http://spring.io/guides/gs/serving-web-content/>
   [Spring-Boot]: <http://projects.spring.io/spring-boot/>
   [Spring-Data-JPA]: <http://projects.spring.io/spring-data-jpa/>
   [Hibernate]: <http://hibernate.org/>
   [H2DB]: <http://www.h2database.com/>
   [Embedded-Tomcat-8]: <http://tomcat.apache.org/tomcat-8.0-doc/index.html>

