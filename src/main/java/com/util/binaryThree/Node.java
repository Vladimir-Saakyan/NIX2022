package com.util.binaryThree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public void printNode(){
        System.out.println("Your change node - " + value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
