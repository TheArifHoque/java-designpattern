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

class LazySingleton {
    /*
    LazySingleton initializes object/instances only when it's needed.
    So it is resource friendly. It won't create object/instance until it's called
     */
    private static LazySingleton instance = null; //Object is not initialized
    private LazySingleton() {
        //constructor is private so no other class can create its object
        System.out.println("LazySingleton Object");
    }

    public static LazySingleton getInstance(){
        if (instance==null){
            synchronized (LazySingleton.class){
                /*
                synchronized is used to get rid of thread complexity
                it is used to reduce the scenario if there are multiple request at the same time to create object
                that time only one is given access and able to create object
                 */
                if (instance==null){
                    instance = new LazySingleton(); //Object created
                }
            }
        }
        return instance;
    }
}

class EagerSingleton {
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
