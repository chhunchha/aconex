# Contract Management

## Background

In the world of capital projects, many organizations have the need to formally manage the financial terms of the contracts that they enter into. It is a direct and straightforward way to get a sense of how much money has been spent on a project, and how much money is expected to be received by the organization performing the work. Typically, this area is called Contract Management.

Contract managers have several areas of interest:
  - Budgets (how much money did I expect to spend/receive)
  - Commitments (how much money have I committed to spending/receiving)
  - Forecasts (how much money in the future will I have to spend/receive)
  - Payments (how much money has actually left/arrived in my bank account)

The combination of these items is sufficient to get a sense of the performance of the project from a financial perspective.

This project is implemented using a framework called [Dropwizard](http://www.dropwizard.io/0.9.2/docs/) which bundles together the following tools:
  - Jetty for an HTTP Server
  - Jackson for serialization
  - Jersey for a REST framework
  - Hibernate for ORM
  - Liquibase for migrations
  - Mustache for view templating

The user interface is comprised of:
  - AngularJS
  - Bootstrap

## Instructions

### Prerequisites

Please ensure you have the following installed:

  - Java 1.8
  - Maven 3
  - Git
  - An IDE (IntelliJ IDEA preferred - Community Edition is fine)

### Running

After cloning this repository, run the application as follows from your terminal:

```
cd /path/to/repository

# First build the application
mvn clean install -DskipTests=true

# Migrate the database
java -jar target/contract-1.0.0-SNAPSHOT.jar db migrate src/main/resources/app.yml

# Run the application from the command line
java -jar target/contract-1.0.0-SNAPSHOT.jar server src/main/resources/app.yml
```

You should now be able to view the application by visiting [http://localhost:9090/](http://localhost:9090/)

///////////////////////

Run h2 browser
java -jar /aconex/h2/bin/h2-1.3.176.jar


jdbc:h2:/aconex/contract-management/target/contract_data