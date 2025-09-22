# Alumni Database Search Engine

## Overview
The **Alumni Database Search Engine** is a **Java console application** built using **Object-Oriented Programming (OOP)** concepts.  
It allows you to manage and search alumni records efficiently, simulating a real-world alumni management system for a college or university.

---

## Features
- **Add Alumni:** Add new alumni with details such as name, graduation year, branch, email, and company.  
- **Display Alumni:** View all alumni records in a structured format.  
- **Search Alumni:**  
  - By Name  
  - By Graduation Year  
  - By Branch  
- **Update Alumni:** Modify existing alumni records.  
- **Delete Alumni:** Remove alumni records.  
- **Statistics / Reports:**  
  - Count of alumni by branch  
  - Count of alumni by graduation year  
- **Export to CSV:** Save all alumni records to a CSV file for external use (Excel or sharing).

---

## Technologies Used
- **Programming Language:** Java  
- **Core Concepts:**  
  - Object-Oriented Programming (Classes, Objects, Inheritance, Encapsulation)  
  - Collections (`ArrayList`)  
  - File Handling (for CSV export)  
- **Build & Run:** Console-based application  

---

## Project Structure
AlumniDatabase/
│
├── src/
│   ├── Alumni.java          // Class representing an alumni
│   ├── AlumniDatabase.java  // Database class handling CRUD operations
│   ├── Searchable.java      // Interface for search methods
│   └── Main.java            // Main program with menu interface
│
├── README.md                // Project documentation
├── screenshots/             // Folder containing screenshots of program output
│   ├── add_alumni.png
│   ├── search_alumni.png
│   └── export_csv.png
└── output/                  // (Optional) Folder to save exported CSV files

---

## How to Run
1. Clone the repository: 
git clone https://github.com/yourusername/AlumniDatabase.git

2.Navigate to the project folder:
cd AlumniDatabase/src

3.Compile all Java files:
javac *.java

4.Run the program:
java Main


Follow the menu options to:

Add alumni

Display alumni

Search alumni (by name, year, or branch)

Update or delete alumni records

Export records to CSV

## Contribution
This project is developed as part of the B.E. CSE curriculum.
For improvements or suggestions, feel free to open an issue or submit a pull request.

## License
This project is free to use and modify for learning purposes.



