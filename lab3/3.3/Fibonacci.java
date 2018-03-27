package com.tasks3.fibonacci;

public class Fibonacci
{
    long first = 1;
    long second = 1;
    long result;
    long iter = 2;

    public long getNumber(int position){
        if (position <= 30 && position > 0) {
            if (position == 1) {
                return first;
            } else if (position == 2) {
                return second;
            } else if (iter != position) {
                result = first + second;
                first = second;
                second = result;
                iter++;
                return getNumber(position);
            } else return result;
        } else return - 1;
    }
}