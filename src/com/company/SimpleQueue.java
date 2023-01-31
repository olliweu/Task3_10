package com.company;

public interface SimpleQueue<T> {
    void addElement(T element);
    int count();
    boolean isEmpty();
    T removeElement() throws Exception;
    T getElement() throws Exception;
}
