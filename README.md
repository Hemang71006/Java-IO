# Java IO

## Overview

The Java IO project is a Java-based application that demonstrates console input/output and file-handling operations.

The application reads employee payroll details from the console, displays employee information, performs file and directory operations, monitors directories, and stores and retrieves payroll records using Java File I/O.

The project covers the six use cases specified in the Bridgelabz Java IO assignment.

## Objectives

- Read employee ID, name, and salary from the console and display payroll information.
- Demonstrate file and directory operations, including creation, deletion, and listing.
- Monitor a directory using Java's Watch Service.
- Write employee payroll records to a file.
- Print payroll records and count file entries.
- Read payroll data from a file for further analysis.
- Follow the Git branching and merging workflow.
- Implement and verify each use case before merging it into the `develop` branch.

## Technologies Used

- Java
- Java File I/O
- Java NIO and Watch Service
- Maven
- JUnit
- Git and GitHub
- IntelliJ IDEA

## Use Cases Covered

| **Use Case** | **Description** | **Requirement** |
|---|---|---|
| UC 1 | Employee Payroll Console I/O | Create an Employee Payroll class containing employee ID, name, and salary. Read employee details from the console and display them. |
| UC 2 | File Operations | Check whether a file exists, delete a file, create a directory and an empty file, and list files, directories, and files with a specified extension. |
| UC 3 | Directory Watch Service | Watch a specified directory, including its files and subdirectories, and count entries using File I/O. |
| UC 4 | Write Payroll to File | Create employee payroll objects, write payroll records to a file, and count entries to verify the operation. |
| UC 5 | Print Payroll Records | Read and print payroll records from the file and count entries to verify the operation. |
| UC 6 | Read Payroll File | Read employee payroll data from the file so that further analysis can be performed. |

## Testing Approach

JUnit tests will be used to verify the behavior of the implemented file and payroll operations.

### File Operation Tests

Test whether files and directories can be checked, created, deleted, and listed as required.

### Payroll File Tests

Verify that payroll records are written correctly, can be read and printed, and that the expected number of entries is present.

### Directory Watch Service Tests

Check the directory-monitoring functionality and verify that the required entries can be counted.

## Project Structure

The project follows a Maven directory structure. Class and package names may be updated as the use cases are implemented.

```text
Java-IO/
├── README.md
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── payroll/
    │           ├── EmployeePayroll.java
    │           └── EmployeePayrollService.java
    └── test/
        └── java/
            └── payroll/
                └── EmployeePayrollServiceTest.java
```
