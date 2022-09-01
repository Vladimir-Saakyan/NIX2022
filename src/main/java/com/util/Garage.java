package com.util;

import com.model.vehicle.Vehicle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Garage<T extends Vehicle> implements LinkList<T>, Iterable<T>{
    private int size =0;
    private LocalTime date;

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
        else {
            last.next = newNode;
            last = newNode;
        }
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
    public T get(int index){
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).el;
    }

    @Override
    public void remove(T el) {
        Node<T> current = first;
        while (current.el!= el){
            current = current.next;
            if(current==null){
                throw new IndexOutOfBoundsException();
            }
        }
        if(current.next != null){
            current.next.last = current.last;
        }
        if(current.last != null) {
            current.last.next = current.next;
        }
    }

    public int amountofRest(int numberofRest) {
        int amount = 0;
        for (int i = 0; i < size; i++) {
            int find = get(i).getNumberRest();
            if (find == numberofRest) {
                System.out.println("your car for that number - " + get(i));
                amount++;
            }
        }
        return amount;
    }

    public boolean removeByNumberOfRestailing(int numberofRest){
        for (int i = 0; i < size; i++) {
            int find = get(i).getNumberRest();
            if (find == numberofRest) {
                System.out.println("your car for that number - " + get(i));
                remove(get(i));
            }
        }
        return false;
    }
    public boolean findByRestNumber(int number){
        for (int i = 0; i < size; i++) {
            int find = get(i).getNumberRest();
            if (find == number) {
                System.out.println("your car for that number - " + get(i));
            }
        }
        return false;
    }
    @Override
    public String getDate(int index){
        return getDate(index);
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



    @Getter
    static class Node<T> {
        T el;
        Node<T> next;
        Node<T> last;

        public Node(T el){
            this.el = el;
        }

        public static <T> void link(Node<T> first, Node<T> second){
            first.next = second;
        }
    }

    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {

        private Node<T> curr;

        public MyLinkedListIterator() {
            this.curr = first;
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T value = curr.el;
            curr = curr.next;
            return value;
        }
    }

}
