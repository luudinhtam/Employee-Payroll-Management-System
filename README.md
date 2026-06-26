# Employee Payroll Management System

A Java console application for managing employee records and calculating monthly payroll. The system provides essential employee management features, including CRUD operations, searching, payroll calculation, and persistent data storage using text files.

## Features

* Load employee data from a text file
* Add new employees with input validation
* Update employee information
* Remove employees by ID
* Search employees by ID, name, role, or status
* Calculate monthly payroll for active employees
* Display all employee records
* Save changes to a file before exiting

## Technologies

* **Language:** Java
* **Programming Paradigm:** Object-Oriented Programming (OOP)
* **Data Storage:** Text File (`employees.txt`)
* **Input Validation:** Regular Expressions (Regex)

## Project Structure

```text id="bqjbxn"
Employee-Payroll-Management/
├── src/
│   ├── core/
│   │   ├── Employee.java
│   │   └── EmployeeList.java
│   ├── tool/
│   │   └── ConsoleInputter.java
│   └── Manager.java
├── employees.txt
└── README.md
```

## Class Overview

| Class             | Description                                                      |
| ----------------- | ---------------------------------------------------------------- |
| `Employee`        | Represents an employee with personal and payroll information.    |
| `EmployeeList`    | Manages employee records and implements business operations.     |
| `ConsoleInputter` | Handles user input and validates data using regular expressions. |
| `Manager`         | Entry point of the application containing the main menu.         |

## Getting Started

### Prerequisites

* Java Development Kit (JDK 8 or later)

### Run the Application

1. Clone this repository.
2. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, or NetBeans).
3. Build and run `Manager.java`.
4. Use the console menu to manage employee records.

## Data Storage

Employee information is stored in the `employees.txt` file. The application automatically loads existing data at startup and allows users to save changes before exiting.

## Learning Objectives

This project demonstrates:

* Object-Oriented Programming principles
* Class design and encapsulation
* Collection Framework (`ArrayList`)
* File input/output
* Data validation with Regular Expressions
* Modular software organization

## Author

Course project – Employee Payroll Management System.
