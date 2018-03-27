package com.tasks3.linkedlist;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 100; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(7));
        linkedList.delete(7);
        System.out.println(linkedList.get(7));
    }
}