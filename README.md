# AutoPrime

# Project evolutions in relation to First Deliverable feedback:

-Sequence Diagram of the System (DSS): Correction of Case 06 (CS06).

-Development of the Conceptual Model.

-Class Diagram: Changes were made to reflect interactions and refactoring based on the adopted design patterns.

-Interaction Diagrams: We corrected the CS06, CS13 diagrams.

-Use Case Diagram: We corrected the use case diagrams based on the feedback from the first delivery.

-System Architecture: Justification of the architecture considering some system requirements

# Group Collaboration Policy:

* Felipe Mendes Salles: Description of the System Scope; Definition of the adopted architectural patterns; Justification of the architectural decisions adopted based on the system's quality attributes; Use Cases; Diagram with the system's overview (organization), including the architectural styles used and justifications for use; Description of how the software architecture contributes to the system's important quality attributes; Class Diagram; Liskov Substitution Pattern, Controller Pattern, GoF Pattern - Factory Method; Implementation of Client and Employee (Back-End and Front-End), System LPS.

* Gabriel Tavares Gargur: Interaction Diagrams; Architectural Requirements; Class Diagram, Project Configuration, Open-Closed; High Cohesion; Decorator; Scheduling Implementation (Back-End and Front-End), Troubleshooting of Members.

* Guilherme França Moreira: System Sequence Diagrams; Use Case Diagram; Architectural Requirements; Class Diagram, Interface Segregation; Loose Coupling; Singleton; Implementation of the Stock and Vehicles Back-End and Front-End, in addition to improving the Purchasing Back-End and the Purchasing Front-End.

* Pedro Arthur Nascimento Resende: Sequence Diagrams; Use Case Diagram; Architectural Requirements; Class Diagram; Conceptual Model; Single Responsibility; Expert; Command; Implementation of the Purchase Back-End.

* Victor Miranda Florido: Description of the System Scope; Definition of the architectural standards adopted; Justification of the architectural decisions adopted based on the system's quality attributes; Use Cases; Description of how the software architecture contributes to the system's important quality attributes; Class Diagram; Dependency Inversion; Creator; Observer; Implementation of the Employee, Main, Manager functions and creation of classes.

# Instructions for executing the project:

- Have maven, Java and mysql installed.

-Run all the SQL scripts found in the SQL folder in your database
-Go to target/classes/application.properties and enter your MySQL information
-Go to CRUD and run .\mvwn spring-boot:run
-Now go to your web browser and type localhost:8080/
-Use the following URLs to access all CRUDs:
vehicle/register
vehicle/list
login
cliente/list
empcionario/list
compra/list
compra/register
agendamentos
agendar

# There is a bug in the edit that causes the date to be initially empty, don't forget to select it before pressing the save button.
