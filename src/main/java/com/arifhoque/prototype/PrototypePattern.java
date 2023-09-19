package com.arifhoque.prototype;

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

        Student student1 = (Student) studentStarter.getClone(); //Creating object by cloning the starter rather than creating with constructor
        student1.getStudentList().add("Arif"); //Modifying object

        Student student2 = (Student) studentStarter.getClone(); //Creating object by cloning the starter rather than creating with constructor
        student2.getStudentList().add("Rakib"); //Modifying object
        student2.getStudentList().add("Faiyaz"); //Modifying object

        System.out.println(studentStarter.getStudentList()); //Printing database
        System.out.println(student1.getStudentList()); //Printing modified object
        System.out.println(student2.getStudentList()); //Printing modified object
    }
}
