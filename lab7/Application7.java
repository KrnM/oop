package com.tasks7.rpn;

import java.util.LinkedList;
import java.util.Deque;

public class Application {

    public static double parse(String rpnString) {
        String[] parsed = rpnString.split(" ");
        Deque<Double> arr = new LinkedList<>();
        if (!parsed[0].matches("-?\\d+(\\.\\d+)?") || !parsed[1].matches("-?\\d+(\\.\\d+)?")) {
            throw new RPNParserException();
        }
        for (int i = 0; i < parsed.length; i++) {
            if (parsed[i].matches("-?\\d+(\\.\\d+)?")) {
                arr.addLast(Double.parseDouble(parsed[i]));
            } else if (!parsed[i].matches("[+\\-*/]")) {
                throw new RPNParserException();
            } else {
                Double last = arr.getLast();
                arr.removeLast();
                Double beforeLast = arr.getLast();
                arr.removeLast();
                switch (parsed[i]) {
                    case "+": {
                        arr.addLast(last + beforeLast);
                        break;
                    }
                    case "-": {
                        arr.addLast(beforeLast - last);
                        break;
                    }
                    case "*": {
                        arr.addLast(last * beforeLast);
                        break;
                    }
                    case "/": {
                        if (last.equals(0.0)) {
                            throw new ArithmeticException();
                        }
                        arr.addLast(beforeLast / last);
                        break;
                    }
                }
            }
        }
        Double result = arr.getFirst();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parse("10 20 + 30 40 + *"));
    }

