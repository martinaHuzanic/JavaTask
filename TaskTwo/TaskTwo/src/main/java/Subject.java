
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
class Subject {
    private int id;
    private String name;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    
    }

    public int getId() {   //This method is a getter for the id field. It allows external code to retrieve the ID of the subject.
        return id;
    }

    public String getName() {  //This method is a getter for the name field. It allows external code to retrieve the name of the subject.
        return name;
    }

    public void setName(String name) {  //This method is a setter for the name field. It allows external code to change the name of the subject.
        this.name = name;
    }

    public Teacher getTeacher() {  // This method is a getter for the teacher field. It allows external code to retrieve the teacher associated with the subject.
        return teacher;
    }

    public void setTeacher(Teacher teacher) {  //This method is a setter for the teacher field. It allows external code to set the teacher for the subject.
        this.teacher = teacher;
    }

    public List<Student> getStudents() {  // This method is a getter for the students field. It allows external code to retrieve the list of students enrolled in the subject.
        return students;
    }

    public void addStudent(Student student) {  //This method allows you to add a student to the list of students enrolled in the subject.
        students.add(student);
    }

    public void removeStudent(Student student) {  //This method allows you to remove a student from the list of students enrolled in the subject.
        students.remove(student);
    }
}




//This Java code defines a class named Subject that represents a subject or course. 

//The Subject class has attributes to store information about the subject, including its ID, name, teacher, and a list of students enrolled in the subject.

// Overall, this Subject class provides a convenient way to represent and manage information about a subject 

//It follows good object-oriented programming principles by encapsulating its data and providing methods to access and modify that data.