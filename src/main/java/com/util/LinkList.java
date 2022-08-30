package com.util;

public interface LinkList<T> {

    void add(T el);

    Garage.Node<T> getNodeByIndex(int index);

    T set(T el);

    T set(int index, T el);

    T get(int index);

    boolean findOfNumber(int number);

    T getFirst();

    T getLast();

    boolean remove(int index);

    boolean contains(T el);

    String getDate(int index);

    boolean isEmpty();

    int size();

    void clear();
}
