package com.arifhoque.prototype_pattern;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {
    /*
    The Prototype Design Pattern is a creational design pattern that deals with the creation of objects,
    specifically by cloning an existing instance, known as a prototype,
    instead of creating new objects using constructors.
    This pattern is particularly useful when the cost of creating an object is more expensive in terms of time and resources than copying an existing one.
     */
    public static void main(String[] args) {
        Student studentStarter = new Student(); //Creating starter object/instance
        studentStarter.loadStudent(); //Load database into starter

        Student student1 = studentStarter.getClone(); //Creating object by cloning the starter rather than creating with constructor
        student1.getStudentList().add("Arif"); //Modifying object

        Student student2 = studentStarter.getClone(); //Creating object by cloning the starter rather than creating with constructor
        student2.getStudentList().add("Rakib"); //Modifying object
        student2.getStudentList().add("Faiyaz"); //Modifying object

        System.out.println(studentStarter.getStudentList()); //Printing database
        System.out.println(student1.getStudentList()); //Printing modified object
        System.out.println(student2.getStudentList()); //Printing modified object
    }
}

interface Prototype {
    /**
     * Interface with getClone() method.
     * To use prototype pattern in any class, we have to implement this interface.
     */
    Prototype getClone();
}

class Student implements Prototype{
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
