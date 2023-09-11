/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martina
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementApp {
    private final Scanner scanner;
    private final List<Student> students;

    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.displayMenu();
    }

    public StudentManagementApp() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Create 5 predefined students
        Student student1 = new Student("John Doe", 12345);
        Student student2 = new Student("Jane Smith", 67890);
        Student student3 = new Student("Alice Johnson", 54321);
        Student student4 = new Student("Bob Wilson", 98765);
        Student student5 = new Student("Eve Brown", 45678);

        // Add these students to the list
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
    }

    private void displayMenu() {
        int option;
        do {
            System.out.println("Menu");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        viewStudents();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exit menu");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 5).");
                scanner.nextLine(); // Clear the invalid input
                option = -1; // Set to -1 to trigger "Invalid choice" message
            }

            System.out.println();
        } while (option != 5);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(student -> {
                student.displayStudentInfo();
            });
        }
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student newStudent = new Student(studentName, studentID);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    public void updateStudent() {
        System.out.print("Enter student name to update: ");
        String studentNameToUpdate = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentNameToUpdate)) {
                System.out.print("Enter new student name: ");
                String newStudentName = scanner.nextLine();
                System.out.print("Enter new student ID: ");
                int newStudentID = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character


                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void deleteStudent() {
        System.out.print("Enter student name to delete: ");
        String studentNameToDelete = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(studentNameToDelete)) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    
    }
}