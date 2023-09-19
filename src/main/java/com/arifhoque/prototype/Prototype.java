package com.arifhoque.prototype;

public interface Prototype {
    /**
     * Interface with getClone() method.
     * To use prototype pattern in any class, we have to implement this interface.
     */
    Prototype getClone();
}
