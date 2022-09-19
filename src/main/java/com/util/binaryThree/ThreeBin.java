package com.util.binaryThree;

import java.util.Stack;

public class ThreeBin {
    private Node roorNode;

    public ThreeBin() {
        roorNode = null;
    }

    public Node findNodeByValue(int value) {
        Node currentNode = roorNode;
        while (currentNode.getValue() != value){
            if(value < currentNode.getValue()){
                currentNode = currentNode.getLeftChild();
            }else {
                currentNode = currentNode.getRightChild();
            }
            if(currentNode == null){
                return null;
            }
        }
        return currentNode;
    }

    public void createNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if(roorNode == null){
            roorNode = new Node();
        }else{
            Node currentNode = roorNode;
            Node parentNode;
            while (true){
                parentNode = currentNode;
                if (value == currentNode.getValue()) {
                    return;
                } else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if(currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }else {
                    currentNode = currentNode.getRightChild();
                    if(currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value){
        Node currentNode = roorNode;
        Node parentNode = roorNode;
        boolean isLeftChild = true;
        while (currentNode.getValue()!=value){
            parentNode = currentNode;
            if(value<currentNode.getValue()){
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return false;
            }
        }if(currentNode.getLeftChild()==null && currentNode.getRightChild()== null){
            if(currentNode == roorNode){
                roorNode = null;
            }else if(isLeftChild){
                parentNode.setLeftChild(null);
            }else parentNode.setRightChild(null);
        }else if(currentNode.getRightChild()==null){
            if(currentNode == roorNode){
                roorNode = currentNode.getLeftChild();
            }else if(isLeftChild){
                parentNode.setLeftChild((currentNode.getLeftChild()));
            }else parentNode.setRightChild(currentNode.getRightChild());
        } else if (currentNode.getLeftChild()== null) {
            if(currentNode == roorNode){
                roorNode = currentNode.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(currentNode.getRightChild());
            }else parentNode.setRightChild(currentNode.getRightChild());
        }else {
            Node heir = receivHeir(currentNode);
            if(currentNode==roorNode){
                roorNode = heir;
            } else if (isLeftChild) {
                parentNode.setLeftChild(heir);
            }else parentNode.setRightChild(heir);
        }
        return true;
    }

    private Node receivHeir(Node node){
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode!=null){
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if(heirNode!=node.getRightChild()){
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }

    public void printTree(){
        Stack globalStack = new Stack();
        globalStack.push(roorNode);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "------------------------------------------------------------------------------------------";
        System.out.println(separator);
        while (!isRowEmpty){
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int i = 0; i < gaps; i++){
                System.out.print(' ');
            }
            while(globalStack.isEmpty() == false){
                Node temp = (Node) globalStack.pop();
                if(temp!=null){
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if(temp.getLeftChild()!=null|| temp.getRightChild()!=null){
                        isRowEmpty = false;
                    }
                }else {
                    System.out.print("___");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < gaps*2-2; i++){
                    System.out.print(' ');
                }
            }
            System.out.println();
            gaps = gaps /2;
            while (localStack.isEmpty() == false){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(separator);
    }
}
