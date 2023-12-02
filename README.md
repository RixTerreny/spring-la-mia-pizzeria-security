# Pizza Management Web Application  :pizza:

This is a sample web application to help manage pizzerias. It allows you to view, create, update, and delete pizza records in the database. Additionally, it supports managing special offers and ingredients and this CRUD operation can be made only by an `ADMIN` not by an `USER`.

## Main Technologies Used

- Java
- Spring Boot
- Thymeleaf
- phpMyAdmin

## Setup and Installation

1. Clone the repository to your local machine.
2. Import the project into your preferred IDE as a Maven project.
3. Build the project using Maven.

## Database Configuration

This application uses phpMyAdmin as database. The database configuration can be found in the `application.properties` file, the file is not present in the repository due to security reason and it needs to be generated in the `resources` pacage. On application startup, the necessary database tables will be created automatically.

## Entity (Pizza)

The `Pizza` entity represents a pizza in the application. It has the following properties:

- `id` (Auto-generated)
- `name` (String)
- `description` (String)
- `imgUrl` (String)
- `price` (Double)

## Pizza's CRUD Operations

### Create

- URL: `/create`
- Method: `GET`
- Description: Displays a form to create a new pizza.

### Save (Create)

- URL: `/create`
- Method: `POST`
- Description: A new pizza will be created and saved to the database.

### Read (Index)

- URL: `/`
- Method: `GET`
- Description: Displays a list of all pizzas in the database. If there are no pizzas, a message indicating that the list is empty will be shown.

### Read (Details)

- URL: `/{id}`
- Method: `GET`
- Description: Displays the details of a specific pizza based on the provided ID.

### Update

- URL: `/edit/{id}`
- Method: `GET`
- Description: Displays a form to edit the details of a specific pizza based on the provided ID.

### Save (Edit)

- URL: `/edit/{id}`
- Method: `POST`
- Description: Update the pizza with the given ID from the database with the new information.

### Delete

- URL: `/delete/{id}`
- Method: `POST`
- Description: Deletes the pizza with the given ID from the database.

## Validations

- The pizza name, description, image URL, and price are required fields.

## Discount's CRUD Operations

### Create Discount

- URL: `/discount/create`
- Method: `GET`
- Description: Displays a form to create a new discount for a specific pizza.

### Save Discount

- URL: `/discount/create`
- Method: `POST`
- Description: Saves the discount data to the database for a specific pizza.

### Update Discount

- URL: `/discount/edit/{id}`
- Method: `GET`
- Description: Displays a form to edit the details of a specific discount for a pizza.

### Save Update Discount

- URL: `/discount/edit/{id}`
- Method: `POST`
- Description: Update the discount data to the database for a specific pizza.

### Delete Discount 

- URL: `/discount/edit/{id}`
- Method: `POST`
- Description: Deletes the discount with the given ID from the database for a specific pizza.

## Ingredient Operations

### List Ingredients

- URL: `/ingredient`
- Method: `GET`
- Description: Displays a list of all ingredients used in the pizzeria. Allows adding new ingredients and deleting existing ones.

### Create Ingredient

- URL: `/ingredient/create`
- Method: `GET`
- Description: Displays a form to create a new ingredient.

### Save Ingredient

- URL: `/ingredient/create`
- Method: `POST`
- Description:  Saves the ingredient data to the database.

### Save Ingredient

- URL: `/ingredient/delete/{id}`
- Method: `POST`
- Description:  Delete the ingredient from the database.

## How to Use

1. Start the application using your IDE or by running the JAR file.
2. Access the application in your web browser at `http://localhost:8080`.
3. On the homepage, you will see a list of all pizzas in the database (if any). If there are no pizzas, a message indicating that the list is empty will be shown.
4. Click on the "Create New Pizza" button to add a new pizza to the database.
5. On the pizza creation form, fill in the required details and click the "Save" button to create the pizza.
6. You can view the details of each pizza by clicking on the pizza's name or on a designated link/button.
7. To edit the details of a pizza, click the "Edit" button on the pizza details page and update the information as needed.
8. To delete a pizza, click the "Delete" button on the pizza details page.

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


In conclusion, this Pizza Management Web Application provides a user-friendly interface for efficiently managing pizzerias, offering a seamless experience for creating, updating, and deleting pizza records, along with handling special offers and ingredients. The security features ensure that only authorized administrators can perform critical CRUD operations, enhancing the overall system integrity. Enjoy managing your pizzeria effortlessly with this application! 🍕

## Project Status

⚠️ **Attention: This project is no longer actively maintained.**

This means there will be no new developments or security updates. We recommend considering more up-to-date and supported alternatives for your needs thanks for the collaboration.

