# Spring Expression Language (SpEL) Simple Rule Engine Example

This repository contains an example application that demonstrates the usage of Spring Expression Language (SpEL) for evaluating dynamic expressions and triggering actions based on rules.

## Overview

The application consists of two entities: `Rule` and `Vehicle`. The `Rule` entity represents a rule definition, including the expression to be evaluated and the bean and method to be invoked if the expression evaluates to true. The `Vehicle` entity represents a vehicle with properties such as code, purchase year, and type.

The application uses the H2 in-memory database to persist the data and Spring Data JPA for data access and manipulation.

The application includes an expression evaluation utility and an example class, `TriggerRuleExample`, which demonstrates the evaluation of rules based on SpEL expressions.

## Entities

### Rule

The `Rule` entity represents a rule definition.

Attributes:
- `id`: The unique identifier for the rule.
- `type`: The type of the rule.
- `expression`: The SpEL expression to be evaluated.
- `beanName`: The name of the bean on which the method will be invoked.
- `methodName`: The name of the method to be invoked on the bean.

### Vehicle

The `Vehicle` entity represents a vehicle.

Attributes:
- `id`: The unique identifier for the vehicle.
- `code`: The code of the vehicle.
- `purchaseYear`: The year in which the vehicle was purchased.
- `type`: The type of the vehicle.

## Technologies Used

The project utilizes the following technologies:

- Spring Boot: A framework for creating Spring-based Java applications with ease.
- Spring Expression Language (SpEL): A powerful expression language for evaluating dynamic expressions.
- H2 Database: An in-memory database for development and testing purposes.
- Spring Data JPA: A framework that simplifies data access and manipulation using the Java Persistence API (JPA).

## Usage

To run the example and see how SpEL expressions are evaluated based on the defined rules, follow these steps:

1. Configure the database connection and other properties in the application properties file (`application.properties` or `application.yml`).
2. Build and run the application using a Java IDE or command line tools.
3. The `TriggerRuleExample` class will demonstrate the evaluation of rules based on the provided expressions.

Feel free to modify the rules, expressions, and associated actions to suit your requirements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.
