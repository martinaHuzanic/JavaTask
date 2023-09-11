/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martina
 */
    public class Student {
        private String name;
        private int studentID;

        public Student(String name, int studentID) {
            this.name = name;
            this.studentID = studentID;
        }

        public String getName() {
            return name;
        }

        public int getStudentID() {
            return studentID;
        }

        public void updateStudent(String newName, int newStudentID) {
            this.name = newName;
            this.studentID = newStudentID;
        }

        public void displayStudentInfo() {
            System.out.println("Name: " + name);
            System.out.println("Student ID: " + studentID);
        }
    }
