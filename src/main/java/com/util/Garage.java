package com.util;

import com.model.vehicle.Vehicle;

import java.sql.Time;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Garage<T extends Vehicle> implements LinkList<T> {
    private int size=0;

    private Node<T> first;
    private Node<T> last;

    public static <T extends Vehicle> LinkList<T> of(T... el){
        Garage<T> linkedListGarage = new Garage<>();
        for (T e : el){
            linkedListGarage.add(e);
        }
        return linkedListGarage;
    }

    @Override
    public void add(T el) {
        Node<T> newNode = new Node<>(el);
        if(first == null) first = last = newNode;
        else this.last.next = newNode;
        size++;
    }

    @Override
    public Node<T> getNodeByIndex(int index){
        Node<T> current = first;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(int index, T el){
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.el = el;
    }

    @Override
    public T get(int index){
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).el;
    }

    @Override
    public T getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return get(size-1);
    }

    @Override
    public T remove(int index){
        Objects.checkIndex(index, size);
        T removeElevent;
        if(index == 0){
            removeElevent = first.el;
            first = first.next;
            if(first == null){
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removeElevent = prev.el;
            prev.next = prev.next.next;
            if(index == size-1){
                last = prev;
            }
        }
        size--;
        return removeElevent;
    }

    @Override
    public boolean contains(T el){
        Node<T> current = first;
        for (int i = 0; i < size; i++){
            if(current.el.equals(el)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(){
        return first == null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void clear(){
        first = last = null;
        size = 0;
    }


    static class Node<T> {
        T el;
        private final Time data;
        private final  int restailing;
        Node<T> next;

        public Node(T el, Time data, int restailing){
            this.el = el;
            this.data= data;
            this.restailing =restailing;
        }
    }
}
