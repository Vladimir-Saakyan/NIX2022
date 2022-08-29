package com.util;

import com.model.vehicle.Vehicle;

public interface LinkList<T> {

    void add(T el);

    Garage.Node<T> getNodeByIndex(int index);

    void set(int index, T el);

    T get(int index);

    T getFirst();

    T getLast();

    T remove(int index);

    boolean contains(T el);

    boolean isEmpty();

    int size();

    void clear();
}
