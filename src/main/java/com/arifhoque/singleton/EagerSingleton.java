package com.arifhoque.singleton;

public class EagerSingleton {
    /*
    EagerSingleton initializes object/instance when the class is loaded
    even if it's not needed. So it will take resource anyway.
     */
    private static EagerSingleton instance = new EagerSingleton(); //Object already created

    private EagerSingleton() {
        //constructor is private so no other class can create its object
        System.out.println("EagerSignleton object");
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}
