package com.arifhoque.singleton;

public class LazySingleton {
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
