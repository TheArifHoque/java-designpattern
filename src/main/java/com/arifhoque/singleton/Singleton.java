package com.arifhoque.singleton;

public class Singleton {
    /*
    The Singleton Design Pattern is one of the creational design patterns in software engineering.
    It ensures that a class has only one instance (object) and provides a global point of access to that instance.
    In other words, it restricts the instantiation of a class to a single instance and provides a way to access that instance from any part of the application.
     */
    public static void main(String[] args) {
        /*
         * For first time call to LazySingleton.getInstance() method, a new object will be created.
         * For subsequent call to LazySingleton.getInstance() method, no new object will be created.
         * Previously created object will be re-used here.
         */
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        /*
         * For first time call to LazySingleton.getInstance() method, a new object will be created.
         * For subsequent call to LazySingleton.getInstance() method, no new object will be created.
         * Previously created object will be re-used here.
         */
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
    }
}
