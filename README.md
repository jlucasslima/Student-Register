# Student Registration System

This is an academic project developed for a course in the Computer Science program at PUC-SP (1st Semester of 2026). The system consists of a Java application with a Graphical User Interface (GUI) focused on managing student registrations, applying strong concepts of Object-Oriented Programming (OOP), MVC architecture, and separation of responsibilities.

## Features (Functional Requirements)

- **FR01 - Insert student into the system:** Allows registering new students, with protection against duplicate registration numbers (RA) and validation of the system's maximum capacity.
- **FR02 - Remove a specific student:** Removes records by searching using a unique identifier (RA).
- **FR03 - List registered students:** Dynamically displays all registered students. Allows listing in two formats: Standard or Bibliographic Format (e.g., `SOUZA, João Lucas`).
- **FR04 - Update student data:** Allows modifying student data (Name, Age, and Course) of an existing student, searching by their registration number.

## Business Rules and Validations

The system was designed to be user-friendly and not display technical error messages to the user. All inputs go through strict validation:
- It is not allowed to register students with the same registration number (RA).
- The RA (Academic Registration) accepts only numbers.
- The Name and Course fields accept only letters and spaces.
- Age is validated within a logical range (16 to 80 years).
- Removal and update operations block attempts to modify non-existent registrations.

## Architecture and Organization (Packages)

The code was refactored and divided into packages to ensure readability, reuse, and ease of maintenance:

* `model/`: Contains domain classes (`Aluno`, `Pessoa`, `Texto`, `NomePessoa`). Encapsulation was strictly applied.
* `storage/`: Data persistence layer. Uses the Dependency Inversion Principle through the `IArmazenador` interface, allowing the current implementation (`ArmazenadorArray`) to be replaced in the future (e.g., with a database) without breaking the code.
* `controller/`: Bridge that applies Business Rules (`CadastroAlunos`), connecting the View with the Storage.
* `view/`: User interface. Uses the `IMenu` interface and was implemented via `MenuGrafico` (Java Swing using `JOptionPane`), ensuring that input and output do not mix with business logic.

## How to Run

1. Make sure you have the JDK (Java Development Kit) installed.
2. Clone this repository.
3. Compile the files or open the root folder in an IDE (such as BlueJ, Eclipse, or IntelliJ).
4. Run the main file: `App.java`.

---
**Institution:** PUC-SP - Faculty of Exact Sciences and Technology  
**Laboratory:** LED - Laboratory of Dynamic Structures  
