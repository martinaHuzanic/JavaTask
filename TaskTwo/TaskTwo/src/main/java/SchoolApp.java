
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Martina
 */
public class SchoolApp {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static int teacherIdCounter = 1;
    private static int subjectIdCounter = 1;
    private static int studentIdCounter = 1;

    public static void main(String[] args) {
        // Predefined data
        teachers.add(new Teacher(teacherIdCounter++, "John Doe"));
        teachers.add(new Teacher(teacherIdCounter++, "Jane Smith"));

        students.add(new Student(studentIdCounter++, "Alice Johnson"));
        students.add(new Student(studentIdCounter++, "Bob Smith"));
        students.add(new Student(studentIdCounter++, "Carol Williams"));

        subjects.add(new Subject(subjectIdCounter++, "Mathematics"));
        subjects.add(new Subject(subjectIdCounter++, "Science"));
        subjects.add(new Subject(subjectIdCounter++, "History"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("CRUD Application Menu:");
            System.out.println("1. Add Teacher");
            System.out.println("2. Add Subject");
            System.out.println("3. Add Student");
            System.out.println("4. List Teachers");
            System.out.println("5. List Subjects");
            System.out.println("6. List Students");
            System.out.println("7. Update Teacher");
            System.out.println("8. Update Subject");
            System.out.println("9. Update Student");
            System.out.println("10. Delete Teacher");
            System.out.println("11. Delete Subject");
            System.out.println("12. Delete Student");
            System.out.println("13. Assign Teacher to Subject");
            System.out.println("14. Enroll Student in Subject");
            System.out.println("15. View Subject Details");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addTeacher(scanner);
                        break;
                    case 2:
                        addSubject(scanner);
                        break;
                    case 3:
                        addStudent(scanner);
                        break;
                    case 4:
                        listTeachers();
                        break;
                    case 5:
                        listSubjects();
                        break;
                    case 6:
                        listStudents();
                        break;
                    case 7:
                        updateTeacher(scanner);
                        break;
                    case 8:
                        updateSubject(scanner);
                        break;
                    case 9:
                        updateStudent(scanner);
                        break;
                    case 10:
                        deleteTeacher(scanner);
                        break;
                    case 11:
                        deleteSubject(scanner);
                        break;
                    case 12:
                        deleteStudent(scanner);
                        break;
                    case 13:
                        assignTeacherToSubject(scanner);
                        break;
                    case 14:
                        enrollStudentInSubject(scanner);
                        break;
                    case 15:
                        viewSubjectDetails(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    private static void addTeacher(Scanner scanner) {
        System.out.println("Enter teacher name: ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
            teachers.add(new Teacher(teacherIdCounter++, name));
            System.out.println("Teacher added successfully.");
        } else {
            System.out.println("Teacher name cannot be empty.");
        }
    }

    private static void addSubject(Scanner scanner) {
        System.out.println("Enter subject name: ");
        String subjectName = scanner.nextLine();

        if (!subjectName.isEmpty()) {
            System.out.println("Enter teacher name for this subject: ");
            String teacherName = scanner.nextLine();
            Teacher teacher = new Teacher(teacherIdCounter++, teacherName);
            teachers.add(teacher);

            System.out.println("Choose one of the following options:");
            System.out.println("1. Enroll an existing student");
            System.out.println("2. Add a new student");
            System.out.println("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (choice == 1) {
                    listStudents(); // Display the list of predefined students
                    System.out.println("Enter the ID of the student you want to enroll: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student student = findStudentById(studentId);
                    if (student != null) {
                        Subject subject = new Subject(subjectIdCounter++, subjectName);
                        subject.setTeacher(teacher);
                        subject.addStudent(student);

                        subjects.add(subject);

                        System.out.println("Subject added successfully with associated teacher and student.");
                        // Print the details of the newly added subject
                        System.out.println("Subject Details:");
                        System.out.println(subject.getName() + " class is added successfully! Teacher of this class is " + teacher.getName() + " and the name of a student is " + student.getName());
                    } else {
                        System.out.println("Student not found.");
                    }
                } else if (choice == 2) {
                    System.out.println("Enter the name of the new student: ");
                    String studentName = scanner.nextLine();

                    if (!studentName.isEmpty()) {
                        Student student = new Student(studentIdCounter++, studentName);
                        students.add(student);

                        Subject subject = new Subject(subjectIdCounter++, subjectName);
                        subject.setTeacher(teacher);
                        subject.addStudent(student);

                        subjects.add(subject);

                        System.out.println("Subject added successfully with associated teacher and new student.");
                        // Print the details of the newly added subject
                        System.out.println("Subject Details:");
                        System.out.println(subject.getName() + " class id added successfully! Teacher of this class is " + teacher.getName() + " and the name of the new student is " + student.getName());
                    } else {
                        System.out.println("Student name cannot be empty.");
                    }
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Consume the invalid input
            }
        } else {
            System.out.println("Subject name cannot be empty.");
        }
    }


    private static void addStudent(Scanner scanner) {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        if (!name.isEmpty()) {
            students.add(new Student(studentIdCounter++, name));
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student name cannot be empty.");
        }
    }

    private static void listTeachers() {
        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teacher.getId() + ", Name: " + teacher.getName());
        }
    }

    private static void listSubjects() {
        System.out.println("List of Subjects:");
        for (Subject subject : subjects) {
            System.out.println("ID: " + subject.getId() + ", Name: " + subject.getName());
        }
    }

    private static void listStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }

    private static void updateTeacher(Scanner scanner) {
        System.out.println("Enter teacher ID to update: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Teacher teacherToUpdate = findTeacherById(id);

            if (teacherToUpdate != null) {
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();

                if (!newName.isEmpty()) {
                    teacherToUpdate.setName(newName);
                    System.out.println("Teacher updated successfully.");
                } else {
                    System.out.println("Teacher name cannot be empty.");
                }
            } else {
                System.out.println("Teacher not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void updateSubject(Scanner scanner) {
        System.out.println("Enter subject ID to update: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Subject subjectToUpdate = findSubjectById(id);

            if (subjectToUpdate != null) {
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();

                if (!newName.isEmpty()) {
                    subjectToUpdate.setName(newName);
                    System.out.println("Subject updated successfully.");
                } else {
                    System.out.println("Subject name cannot be empty.");
                }
            } else {
                System.out.println("Subject not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("Enter student ID to update: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Student studentToUpdate = findStudentById(id);

            if (studentToUpdate != null) {
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();

                if (!newName.isEmpty()) {
                    studentToUpdate.setName(newName);
                    System.out.println("Student updated successfully.");
                } else {
                    System.out.println("Student name cannot be empty.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void deleteTeacher(Scanner scanner) {
        System.out.println("Enter teacher ID to delete: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Teacher teacherToDelete = findTeacherById(id);

            if (teacherToDelete != null) {
                teachers.remove(teacherToDelete);
                System.out.println("Teacher deleted successfully.");
            } else {
                System.out.println("Teacher not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void deleteSubject(Scanner scanner) {
        System.out.println("Enter subject ID to delete: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Subject subjectToDelete = findSubjectById(id);

            if (subjectToDelete != null) {
                subjects.remove(subjectToDelete);
                System.out.println("Subject deleted successfully.");
            } else {
                System.out.println("Subject not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("Enter student ID to delete: ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            Student studentToDelete = findStudentById(id);

            if (studentToDelete != null) {
                students.remove(studentToDelete);
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    private static void assignTeacherToSubject(Scanner scanner) {
        System.out.println("Enter subject ID to assign a teacher: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Subject subject = findSubjectById(subjectId);
        if (subject != null) {
            System.out.println("Enter teacher ID: ");
            int teacherId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Teacher teacher = findTeacherById(teacherId);
            if (teacher != null) {
                subject.setTeacher(teacher);
                System.out.println("Teacher assigned to the subject successfully.");
            } else {
                System.out.println("Teacher not found.");
            }
        } else {
            System.out.println("Subject not found.");
        }
    }

    private static void enrollStudentInSubject(Scanner scanner) {
        System.out.println("Enter subject ID to enroll a student: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Subject subject = findSubjectById(subjectId);
        if (subject != null) {
            System.out.println("Enter student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Student student = findStudentById(studentId);
            if (student != null) {
                subject.addStudent(student);
                System.out.println("Student enrolled in the subject successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Subject not found.");
        }
    }

    private static void viewSubjectDetails(Scanner scanner) {
        System.out.println("Enter subject ID to view details: ");
        int subjectId = scanner.nextInt();

        Subject subject = findSubjectById(subjectId);
        if (subject != null) {
            System.out.println("Subject Details:");
            System.out.println("ID: " + subject.getId() + " . Name: " + subject.getName() + ". Teacher: " + (subject.getTeacher() != null ? subject.getTeacher().getName() : "Not assigned") + " .Students: ");
            List<Student> subjectStudents = subject.getStudents();
            if (!subjectStudents.isEmpty()) {
                for (Student student : subjectStudents) {
                    System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
                }
            } else {
                System.out.println("No students enrolled in this subject.");
            }
        } else {
            System.out.println("Subject not found.");
        }
    }

    // Helper methods to find objects by ID
    private static Teacher findTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private static Subject findSubjectById(int id) {
        for (Subject subject : subjects) {
            if (subject.getId() == id) {
                return subject;
            }
        }
        return null;
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}