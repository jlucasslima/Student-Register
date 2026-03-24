# Student Registration System

A **Java** system with a graphical interface for managing and registering students. This project was developed applying solid **Object-Oriented Programming (OOP)** concepts, including inheritance, polymorphism, and interfaces.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![BlueJ](https://img.shields.io/badge/BlueJ-3C8CC7?style=for-the-badge&logo=java&logoColor=white)

---

## Features

The system features an interactive menu (`JOptionPane`) that allows:

- **Insert Student:** Registration with Name, Age, RA (Student ID), and Course.
- **Remove Student:** Deletion of students from the list by name.
- **List Students:** Display of all students registered in the system.
- **Bibliographic Formatting:** Automatic conversion of names to citation format (e.g., *Ze da Silva Pereira Antunes* ➔ *ANTUNES, Ze da Silva Pereira*).
- **Capacity Control:** The system respects the student limit defined by the user at the start of execution.

---

## Technologies Used

- **Language:** Java (JDK)
- **Graphical Interface:** Java Swing (`JOptionPane`)
- **Development Environment:** BlueJ

---

## Project Architecture

The project was built with modularity and best practices in mind. The main classes and interfaces are:

* `Pessoa` / `Aluno`: Model classes using inheritance to represent student data.
* `Texto` / `NomePessoa`: Classes responsible for string handling and formatting (such as generating the bibliographic name).
* `IArmazenador`: Interface that defines the data storage contract.
* `ArmazenadorArray`: Concrete implementation of the `IArmazenador` interface, managing students in an in-memory array.
* `CadastroAlunos`: Controller class that bridges the user interface and the data.
* `IMenu` / `MenuGrafico`: Interface and implementation of the view layer (UI) using pop-up windows.
* `App`: Main class that initializes the system.

---

## How to Run (in BlueJ)

1. Open the project in **BlueJ**.
2. Click the **"Compile"** button to ensure all dependencies are correct.
3. Right-click on the `App` class.
4. Select `void main(String[] args)`.
5. Enter the maximum number of students and interact with the graphical menu!

---
*Developed as a Computer Science study project.*
