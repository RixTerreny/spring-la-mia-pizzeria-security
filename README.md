# Pizza Management Web Application pt. 2  :pizza:

This is a sample web application to help manage a pizzeria. It allows you to view, create, update, and delete pizza records in the database. Additionally, it supports managing special offers and ingredients and this CRUD operation can be made only by an `admin` not by an `user`.

This repo is the extention of [spring-la-mia-pizzeria-crud](https://github.com/RixTerreny/spring-la-mia-pizzeria-crud) and [spring-la-mia-pizzeria-relazioni](https://github.com/RixTerreny/spring-la-mia-pizzeria-relazioni), the readme here is about the new implementation made about security.

## Security
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

For more information about the setup of these classes i suggest to read the official documentation of [Spring Security](https://docs.spring.io/spring-security/reference/).
