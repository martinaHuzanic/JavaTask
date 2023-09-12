
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martina
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private Teacher teacher;
    private List<Student> students;

    public Subject(int subjectId, String subjectName, Teacher teacher) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Method 1: Add a student with a different parameter
    public void addStudent(int studentId, String studentName) {
        Student student = new Student(studentId, studentName);
        students.add(student);
    }

    // Method 2: Set teacher with a different parameter
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // Method 3: Update subject name with a different parameter
    public void updateSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String setSubjectName(String newSubjectName) {
        return subjectName;
    }
}