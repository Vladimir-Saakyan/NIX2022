package com.util;

public class GarageTwo {


    public class Node<T>{
        T element;

        Node<T> next;


        public Node(T element) {
            this.element = element;
        }

        public static <T> void link(Node<T> first, Node<T> second) {
            first.next=second;
        }

        public <T> Node<T> pairOf(T first, T second) {
            Node<T> firstEl= new Node<>(first);
            firstEl.next = new Node<>(second);
            return firstEl;
        }

        public <T> Node<T> closePairOf(T first, T second){
            Node<T> firstEl= new Node<>(first);
            Node<T> secondEl= new Node<>(second);
            firstEl.next = secondEl;
            secondEl.next = firstEl;
            return firstEl;
        }
    }
}
