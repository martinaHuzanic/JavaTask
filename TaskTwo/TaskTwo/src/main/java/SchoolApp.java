
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static final Map<Integer, Teacher> teachers = new HashMap<>();
    private static final Map<Integer, Student> students = new HashMap<>();
    private static final Map<Integer, Subject> subjects = new HashMap<>();
    private static int teacherIdCounter = 1;
    private static int studentIdCounter = 1;
    private static int subjectIdCounter = 1;
    
    

    public static void main(String[] args) {
    Teacher defaultTeacher = new Teacher(teacherIdCounter++, "Default Teacher");
    teachers.put(defaultTeacher.getTeacherId(), defaultTeacher);

    Subject subject1 = new Subject(subjectIdCounter++, "Mathematics", defaultTeacher);
    subjects.put(subject1.getSubjectId(), subject1);

    Subject subject2 = new Subject(subjectIdCounter++, "Science", defaultTeacher);
    subjects.put(subject2.getSubjectId(), subject2);

    Subject subject3 = new Subject(subjectIdCounter++, "History", defaultTeacher);
    subjects.put(subject3.getSubjectId(), subject3);

    Subject subject4 = new Subject(subjectIdCounter++, "English", defaultTeacher);
    subjects.put(subject4.getSubjectId(), subject4);

    Subject subject5 = new Subject(subjectIdCounter++, "Computer Science", defaultTeacher);
    subjects.put(subject5.getSubjectId(), subject5);

    Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Menu");
            System.out.println("9. Create Subject");
            System.out.println("10. Read Subject by ID");
            System.out.println("11. Update Subject by ID");
            System.out.println("12. Delete Subject by ID");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 9:
                    createSubject(scanner);
                    break;
                case 10:
                    readSubject(scanner);
                    break;
                case 11:
                    updateSubject(scanner);
                    break;
                case 12:
                    deleteSubject(scanner);
                    break;
                case 13:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Teacher CRUD operations
    public static void createTeacher(Scanner scanner) {
        System.out.print("Enter teacher name: ");
        String teacherName = scanner.nextLine();

        Teacher teacher = new Teacher(teacherIdCounter++, teacherName);
        teachers.put(teacher.getTeacherId(), teacher);

        System.out.println("Teacher created successfully.");
    }

    public static void readTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Teacher teacher = teachers.get(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found.");
        } else {
            System.out.println("Teacher ID: " + teacher.getTeacherId());
            System.out.println("Teacher Name: " + teacher.getTeacherName());
        }
    }

    public static void updateTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID to update: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Teacher teacher = teachers.get(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.print("Enter new teacher name: ");
        String newTeacherName = scanner.nextLine();

        teacher.setTeacherName(newTeacherName);

        System.out.println("Teacher updated successfully.");
    }

    public static void deleteTeacher(Scanner scanner) {
        System.out.print("Enter teacher ID to delete: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Teacher teacher = teachers.get(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        teachers.remove(teacherId);

        System.out.println("Teacher deleted successfully.");
    }

    // Student CRUD operations
    public static void createStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentIdCounter++, studentName);
        students.put(student.getStudentId(), student);

        System.out.println("Student created successfully.");
    }

    public static void readStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new student name: ");
        String newStudentName = scanner.nextLine();

        student.setStudentName(newStudentName);

        System.out.println("Student updated successfully.");
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = students.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(studentId);

        System.out.println("Student deleted successfully.");
    }

    // Subject CRUD operations
    public static void createSubject(Scanner scanner) {
        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();

        System.out.print("Enter teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Teacher teacher = teachers.get(teacherId);
        if (teacher == null) {
            System.out.println("Teacher not found. Please create the teacher first.");
            return;
        }

        Subject subject = new Subject(subjectIdCounter++, subjectName, teacher);
        subjects.put(subject.getSubjectId(), subject);

        System.out.println("Subject created successfully.");
    }

    public static void readSubject(Scanner scanner) {
        System.out.print("Enter subject ID: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Subject subject = subjects.get(subjectId);
        if (subject == null) {
            System.out.println("Subject not found.");
        } else {
            System.out.println("Subject ID: " + subject.getSubjectId());
            System.out.println("Subject Name: " + subject.getSubjectName());
            System.out.println("Teacher ID: " + subject.getTeacher().getTeacherId());
            System.out.println("Teacher Name: " + subject.getTeacher().getTeacherName());
            List<Student> students = subject.getStudents();
            if (students.isEmpty()) {
                System.out.println("No students enrolled.");
            } else {
                System.out.println("Students Enrolled:");
                students.stream().map(student -> {
                    System.out.println("Student ID: " + student.getStudentId());
                    return student;
                }).forEachOrdered(student -> {
                    System.out.println("Student Name: " + student.getStudentName());
                });
            }
        }
    }

    public static void updateSubject(Scanner scanner) {
        System.out.print("Enter subject ID to update: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Subject subject = subjects.get(subjectId);
        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        System.out.print("Enter new subject name: ");
        String newSubjectName = scanner.nextLine();

        subject.setSubjectName(newSubjectName);

        System.out.println("Subject updated successfully.");
    }

    public static void deleteSubject(Scanner scanner) {
        System.out.print("Enter subject ID to delete: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Subject subject = subjects.get(subjectId);
        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        subjects.remove(subjectId);

        System.out.println("Subject deleted successfully.");
    }
}

