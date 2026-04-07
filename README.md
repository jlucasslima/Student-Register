Student Registration System

This is an academic project developed for a Computer Science course at PUC-SP (1st Semester of 2026). The system consists of a Java application with a Graphical User Interface (GUI) focused on managing student records, applying strong concepts of Object-Oriented Programming (OOP), MVC architecture, and separation of concerns.

Features (Functional Requirements)
FR01 - Add student to the system: Allows registering new students, with protection against duplicate student IDs (RA) and validation of the system's maximum capacity.
FR02 - Remove a specific student: Removes records by searching for a unique identifier (RA).
FR03 - List registered students: Dynamically displays all registered students. Supports two formats: Standard or Bibliographic Format (e.g., SOUZA, João Lucas).
FR04 - Update student data: Allows updating student information (Name, Age, and Course) by searching using their registration number.
Business Rules and Validations

The system was designed to be user-friendly and avoids displaying technical error messages. All inputs are strictly validated:

Duplicate student IDs (RA) are not allowed.
The RA (Academic Registration Number) accepts only numeric values.
Name and Course fields accept only letters and spaces.
Age is validated within a logical range (16 to 80 years).
Removal and update operations prevent actions on non-existent registrations.
Architecture and Organization (Packages)

The code was refactored and organized into packages to ensure readability, reusability, and maintainability:

model/: Contains domain classes (Aluno, Pessoa, Texto, NomePessoa). Encapsulation is strictly applied.
storage/: Data persistence layer. Uses the Dependency Inversion Principle through the IArmazenador interface, allowing the current implementation (ArmazenadorArray) to be replaced in the future (e.g., with a database) without breaking the code.
controller/: Acts as a bridge applying business rules (CadastroAlunos), connecting the View with the Storage layer.
view/: User interface. Uses the IMenu interface and is implemented via MenuGrafico (Java Swing with JOptionPane), ensuring that input/output is separated from business logic.
How to Run
Make sure you have the JDK (Java Development Kit) installed.
Clone this repository.
Compile the files or open the root folder in an IDE (such as BlueJ, Eclipse, or IntelliJ).
Run the main file: App.java.

Institution: PUC-SP - Faculty of Exact Sciences and Technology
Laboratory: LED - Laboratory of Dynamic Structures
