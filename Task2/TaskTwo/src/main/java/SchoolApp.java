
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
    // Adding a predefined teacher for each subject
    Teacher mathTeacher = new Teacher(teacherIdCounter++, "Math Teacher");
    teachers.put(mathTeacher.getTeacherId(), mathTeacher);

    Teacher scienceTeacher = new Teacher(teacherIdCounter++, "Science Teacher");
    teachers.put(scienceTeacher.getTeacherId(), scienceTeacher);

    Teacher historyTeacher = new Teacher(teacherIdCounter++, "History Teacher");
    teachers.put(historyTeacher.getTeacherId(), historyTeacher);

    Teacher englishTeacher = new Teacher(teacherIdCounter++, "English Teacher");
    teachers.put(englishTeacher.getTeacherId(), englishTeacher);

    Teacher computerScienceTeacher = new Teacher(teacherIdCounter++, "Computer Science Teacher");
    teachers.put(computerScienceTeacher.getTeacherId(), computerScienceTeacher);

    // Adding a predefined student for each subject
    Student mathStudent = new Student(studentIdCounter++, "Matko");
    students.put(mathStudent.getStudentId(), mathStudent);

    Student scienceStudent = new Student(studentIdCounter++, "Sheldon");
    students.put(scienceStudent.getStudentId(), scienceStudent);

    Student historyStudent = new Student(studentIdCounter++, "Zahi");
    students.put(historyStudent.getStudentId(), historyStudent);

    Student englishStudent = new Student(studentIdCounter++, "Tea");
    students.put(englishStudent.getStudentId(), englishStudent);

    Student computerScienceStudent = new Student(studentIdCounter++, "Ćiro");
    students.put(computerScienceStudent.getStudentId(), computerScienceStudent);

    Subject subject1 = new Subject(subjectIdCounter++, "Mathematics", mathTeacher);
    subjects.put(subject1.getSubjectId(), subject1);
    subject1.addStudent(mathStudent);

    Subject subject2 = new Subject(subjectIdCounter++, "Science", scienceTeacher);
    subjects.put(subject2.getSubjectId(), subject2);
    subject2.addStudent(scienceStudent);

    Subject subject3 = new Subject(subjectIdCounter++, "History", historyTeacher);
    subjects.put(subject3.getSubjectId(), subject3);
    subject3.addStudent(historyStudent);

    Subject subject4 = new Subject(subjectIdCounter++, "English", englishTeacher);
    subjects.put(subject4.getSubjectId(), subject4);
    subject4.addStudent(englishStudent);

    Subject subject5 = new Subject(subjectIdCounter++, "Computer Science", computerScienceTeacher);
    subjects.put(subject5.getSubjectId(), subject5);
    subject5.addStudent(computerScienceStudent);

    Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Create Subject");
            System.out.println("2. Read Subject by ID");
            System.out.println("3. Update Subject by ID");
            System.out.println("4. Delete Subject by ID");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createSubject(scanner);
                    break;
                case 2:
                    readSubject(scanner);
                    break;
                case 3:
                    updateSubject(scanner);
                    break;
                case 4:
                    deleteSubject(scanner);
                    break;
                case 5:
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
        System.out.print("Enter teacher: ");
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
        System.out.print("Enter teacher: ");
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
        System.out.print("Enter student: ");
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
        System.out.print("Enter student:  ");
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
        System.out.print("Enter student:  ");
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

