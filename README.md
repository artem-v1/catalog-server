# Project: Backend for a Company Catalog Web Application

## Objective
To demonstrate my web application development skills to potential employers.

##Scope
- Backend: Java 17, Spring Boot, Hibernate, Liquibase
- Frontend: Angular 17 (hosted separately in the same GitHub account)
- Database: PostgreSQL (for backup loading - https://drive.google.com/drive/folders/1CdQfjHnL1k06C6IhJvxfW__enuskEPK1?usp=drive_link )

## Description
The project is a catalog where users can create a web page for their company. The page is designed as a comprehensive landing page with detailed information about the company and commercial offers. Users can search for companies based on geolocation and various characteristics. The application is currently in development.

## Current Backend Features
- Database Table Generation: Set up using Liquibase migrations.
- Entity Class Generation: Configured through Hibernate reverse engineering.
- Data Access: Created entity classes, repositories, services, and controllers to access data via API.
- Test Data: Test data has been saved in the database.
- Characteristics Reference: Created and set up client-side caching.
- Localities Reference: Created a reference of German localities with search functionality based on geolocation and specified radius (backend and database functionality for company search by geolocation is prepared, but not yet implemented on the client side).

## Planned Features
- User Authentication: Implementing authentication via Keycloak.
- User Dashboard: Creating a personal dashboard for users.
- Company Information Forms: Creating forms for publishing company information.
- Company Search Form: Creating a form for searching companies by specified characteristics and geolocation.
- Billing Setup: Setting up online payment processing.