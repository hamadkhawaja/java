package com.company;
public class TripleStack {

    int []stack;
    int []tos = {-1, -1, -1};
    int size = 0;

    TripleStack(int size) {
        this.size = size;
        stack = new int[size * 3];
    }

    public void push(int stackNumber, int element) {
        if (!isFull(stackNumber)) {
            tos[stackNumber]++;
            stack[absoluteTOS(stackNumber)] = element;

        }
    }

    public int pop(int stackNumber) {
        int val = stack[absoluteTOS(stackNumber)];
        if (!isEmpty(stackNumber)) {
            tos[stackNumber]--;
        }
        return val;
    }

    public boolean isFull(int stackNumber) {
        return (tos[stackNumber] < size) ? false : true;
    }

    public boolean isEmpty(int stackNumber) {
        return tos[stackNumber] == -1 ? true : false;
    }

    public int absoluteTOS(int stackNumber) {
        return size * stackNumber + tos[stackNumber];
    }

}
