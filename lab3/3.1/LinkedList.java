package com.tasks3.linkedlist;

public class LinkedList {
    Node head;
    Node node = new Node();

    public LinkedList() {
        head = new Node();
    }

    public void add(Integer data) {
        if (head.getData() == null && head.getNext() == null) {
            head.setData(data);
        } else if (head.getData() != null && head.getNext() == null) {
            head.setNext(node);
            node.setData(data);
        } else {
            while (node.getNext() != null && node.getData() != null) {
                node = node.getNext();
            }
            Node node_next = new Node();
            node.setNext(node_next);
            node_next.setData(data);
        }
    }

    public Integer get(int index) {
        Node arr[] = new Node[index + 1];
        arr[0] = head;
        for (int i = 1; i < index + 1; i++) {
            if (arr[i - 1].getNext() != null) {
                if (arr[i - 1] == head) {
                    arr[i] = head.getNext();
                } else arr[i] = arr[i - 1].getNext();
            } else return null;
        }
        return arr[index].getData();

    }

    public boolean delete(int index) {
        int counter = 0;
        if (head.getData() != null) {
            counter++;
            if (head.getNext() == null) {
            } else {
                counter++;
                node = head.getNext();
                while (node.getNext() != null) {
                    node = node.getNext();
                    counter++;
                }
            }
        }
        int count = 1;
        if (index == 0) {
            head = head.getNext();
            return true;
        } else if (counter < index + 1) {
            return false;
        } else if (index + 1 > 0) {
            Node prev = new Node();
            prev = head;
            //Node nodeDel = new Node();
            node = prev.getNext();
            if (node != null){
                count++;
                while (count < index + 1 && node.getNext() != null){
                    prev = node;
                    node = node.getNext();
                    count++;
                }
                if (count == index + 1){
                    prev.setNext(node.getNext());
                    return true;
                } else return false;
            } else return false;
        } else return false;


    }

    public int size() {
        int counter = 0;
        if (head.getData() != null) {
            counter++;
            if (head.getNext() == null) {
                return counter;
            } else {
                counter++;
                node = head.getNext();
                while (node.getNext() != null) {
                    node = node.getNext();
                    counter++;
                }
                return counter;
            }
        } else return counter;
    }
}