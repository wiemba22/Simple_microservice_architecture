# Simple_microservice_architecture

DEI Microservices Architecture
This repository implements a microservices-based architecture to monitor Diversity, Equity, and Integrity (DEI) metrics in the workforce. The architecture processes data from a DEI.csv file containing 10,000 employee records. Each microservice handles a specific functionality and communicates seamlessly with others.

Projects
1. Manager Microservice
Functionality: This service reads the DEI.csv file and returns a list of employees who hold the "manager" position.
Input: A CSV file with employee records.
Output: A list of employees with the "manager" designation.
2. Veteran Manager Microservice
Functionality: This service consumes the output from the Manager Microservice and calculates the percentage of managers who are veterans.
Input: The list of managers returned by the Manager Microservice.
Output: A percentage of veteran managers.
3. Gender Manager Microservice
Functionality: This service takes the result from the Manager Microservice and calculates the percentage of male and female managers.
Input: The list of managers from the Manager Microservice.
Output: Percentages of male and female managers.

Architecture
The microservices are designed to be independent, communicating through RESTful APIs. All services are containerized using Docker to ensure portability and scalability.

The workflow is as follows:

Manager Microservice reads the DEI.csv file and extracts the managers.

Veteran Manager Microservice calculates the percentage of veteran managers using the data from the Manager Microservice.

Gender Manager Microservice calculates the gender distribution among the managers using the data from the Manager Microservice.

Technologies Used

Spring Boot: For backend development and API creation.

Docker: For containerizing the microservices and ensuring scalability.

CSV Parsing: For reading and processing the DEI.csv file containing employee data.

RESTful APIs: For communication between the microservices.

