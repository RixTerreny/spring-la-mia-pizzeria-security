# Pizza Management Web Application pt. 3  :pizza:

This is a sample web application to help manage pizzerias. It allows you to view, create, update, and delete pizza records in the database. Additionally, it supports managing special offers and ingredients and this CRUD operation can be made only by an `ADMIN` not by an `USER`.

This repo is the extention of [spring-la-mia-pizzeria-crud](https://github.com/RixTerreny/spring-la-mia-pizzeria-crud) and [spring-la-mia-pizzeria-relazioni](https://github.com/RixTerreny/spring-la-mia-pizzeria-relazioni), the readme here is about the new implementation made about security.

## Security Setup
Add spring-boot-starter-security to your pom.xml like this:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
The code inherent spring boot security can be found in the package security with these classes on the inside:
- DatabaseUserDetails
- DatabaseUserDetailsService
- SecurityConfiguration

For more information about the setup of these classes i suggest you to read the official documentation of [Spring Security](https://docs.spring.io/spring-security/reference/).

## Security Features
The role expected are 2:
- `ADMIN`
- `USER`

The USER can only visualize the index or the details of the pizzas, while all the other CRUD can be managed only by an ADMIN.
