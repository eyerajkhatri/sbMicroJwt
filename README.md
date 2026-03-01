Author: Raj Khatri, Email: khatriraj200@gmail.com

This microservice project contains 4 services: Eureka (used locally for service discovery), API Gateway, Auth Service, User Details Service. Login happens in Auth service and JWT token is generated here. Other services validate and use that token for secured endpoints. User details are fetched from User Details service after authentication. Also, new account creation is handled by User Details service.

How services communicate? For service to service communication I am using OpenFeign. Instead of writing RestTemplate calls manually, Feign client is used for convenience.

In AWS ECS setup, I am using AWS CloudMap for service discovery instead of Eureka. So locally it works with Eureka, but on AWS it uses CloudMap for resolving services.

Caching: I have implemented Hibernate L2 caching using Ehcache. This is mainly used for improving read performance in user related operations so database is not hit every time.

Tech used: Java 17, Spring Boot, Spring Security, JWT, Spring Cloud Gateway, OpenFeign, Ehcache (Hibernate L2 Provider), Eureka (local), Maven, Docker, ECS, AWS ECR, CloudMap (ECS service discovery), RDS (MYSQL Provider) and ALB

Note: This is mainly a demonstration focused project. UI is very minimal because honestly my main area of work is backend development so focus is more on backend communication and security.

Live Demo: The application is hosted in AWS ECS in a Docker container and an ALB is created for the application.

You can check the application live here: https://www.rajkhatridev.online