package com.util;

import com.model.vehicle.Vehicle;

public interface LinkList<T> {

    void add(T el);

    Garage.Node<T> getNodeByIndex(int index);

    T get(int index);

    void remove(T el);

    String getDate(int index);

    boolean isEmpty();

    int size();

    void clear();
}
