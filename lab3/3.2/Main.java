package com.tasks3.carddeck;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.drawOne().getRank().getName()+deck.drawOne().getSuit().getName());
    }
}