package com.arifhoque.prototype;

import java.util.ArrayList;
import java.util.List;

public class Student implements Prototype{
    /**
     * Demo class where we will implement prototype pattern.
     * For that we are implementing Prototype interface.
     */
    private List<String> studentList;

    public Student() {
        //Default constructor
        studentList = new ArrayList<>();
    }

    public Student(List<String> studentList) {
        //All argument constructor
        this.studentList = studentList;
    }

    public void loadStudent(){
        //Method to load database
        studentList.add("Student 1");
        studentList.add("Student 2");
        studentList.add("Student 3");
        studentList.add("Student 4");
    }

    public List<String> getStudentList(){
        //Method to get student list
        return studentList;
    }

    /**
     * Instead of creating a new empty object each time, we are cloning the exiting object.
     *
     * @return Student
     */
    /*
    In previous version of code return type was Prototype as it was overriding from Prototype interface
    but with overriding rule we can change the signature of the method .
    so we made the return type as Student to avoid typecasting in main method.
     */
    @Override
    public Student getClone() {
        //Method to clone existing object and return
        List<String> studentListClone = new ArrayList<>(this.getStudentList());
        return new Student(studentListClone);
    }
}
