package com.util;

import com.model.vehicle.Vehicle;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Garage<T extends Vehicle> implements LinkList<T>, Iterable<T>{
    private int size =0;
    private String date;

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
    public T set(T el){
        size++;
        Node<T> node = new Node<>(el);
        last = node;
        return last.el;
    }

    @Override
    public T set(int index, T el){
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        T oldVal = node.el;
        node.el = el;
        return oldVal;
    }

    @Override
    public T get(int index){
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).el;
    }

    @Override
    public boolean findOfNumber(int number) {
        for (int i = 0; i < size; i++) {
            int find = get(i).getNumberRest();
            if (find == number) {
                System.out.println("your car for that number - " + get(i));
            } throw new IllegalArgumentException("number is not " + number);
        }
        return false;
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
        return get(size -1);
    }

    @Override
    public boolean remove(int numberofRest){

        for (int i = 0; i<size; i++){
            if(numberofRest == get(i).getNumberRest()){
                Node<T> prev = getNodeByIndex(i-1);
                prev.next=prev.next.next;
                size--;
            }else System.out.println(numberofRest + "no this car");
        }
        return false;
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

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
