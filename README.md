# Emergency Patient Management System

A Java-based **Emergency Patient Management System** that manages patients waiting for examination using a **Singly Linked List**.

Patients are organized according to their priority level, where **Priority 1 is the highest** and **Priority 5 is the lowest**.

## 📌 Features

* Create patient records
* Add patients according to priority
* Maintain insertion order for patients with the same priority
* Remove a patient using Patient ID
* Search for a patient
* Change patient priority
* Automatically reposition patients after priority changes
* Count total waiting patients
* Serve the next patient
* Display patients by a specific priority
* Display the complete waiting list

## 🏥 Patient Structure

Each patient node contains:

```text
Patient ID | Patient Name | Priority | Next
```

Example:

```text
[P12 | Ayesha | 1] → [P18 | Hamza | 2] → [P07 | Bilal | 4] → null
```

### Priority System

| Priority | Meaning |
| -------- | ------- |
| 1        | Highest |
| 2        | High    |
| 3        | Medium  |
| 4        | Low     |
| 5        | Lowest  |

Patients with the same priority maintain their **original insertion order**.

## 🛠️ Data Structure Used

This project uses a **Singly Linked List**.

Each node stores:

* Patient ID
* Patient Name
* Priority
* Reference to the next patient

The waiting list is maintained in ascending priority order.

## ⚙️ Main Operations

### Add Patient

`addPatient()`

Adds a patient at the correct position according to priority.

### Remove Patient

`removePatient(String id)`

Removes a patient from the waiting list using their unique Patient ID.

### Search Patient

`searchPatient(String id)`

Searches the linked list and displays patient information.

### Change Priority

`changePriority(String id, int newPriority)`

Changes a patient's priority and places the patient at the correct position.

### Count Patients

`countPatients()`

Returns the total number of patients currently waiting.

### Serve Next Patient

`serveNextPatient()`

Serves and removes the first patient in the list because the first patient has the highest priority.

### Display By Priority

`displayByPriority(int priority)`

Displays all patients having the selected priority.

### Display Waiting List

`displayWaitingList()`

Displays the complete waiting list in priority order.

## 💻 Technologies

* Java
* Singly Linked List
* Object-Oriented Programming
* Basic Searching and Traversal

## 📂 Project Structure

```text
JavaDSA/
│
├── Main.java
└── README.md
```

## ▶️ How to Run

Make sure Java JDK is installed.

Compile the program:

```bash
javac Main.java
```

Run the program:

```bash
java -cp . Main
```

## 🎯 Learning Objectives

This project demonstrates practical implementation of:

* Singly Linked Lists
* Node creation
* Insertion
* Deletion
* Searching
* Traversal
* Updating node information
* Priority-based data organization

## 👨‍💻 Author

**Muhammad Hammad**

BS Software Engineering
COMSATS University Islamabad — Attock Campus

GitHub: [HamadKdev](https://github.com/hamadKdev)
