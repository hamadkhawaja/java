/**
 * Created by Hamad on 04/05/2015.
 */
public class Stack {
    int size = 0;
    int tos = -1;
    int []stack;

    Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    boolean isEmpty()
    {
        return tos == -1;
    }

    boolean isFull() {
        return tos == (size - 1);
    }

    void push(int element) {
        if (!isFull()) {
            stack[++tos] = element;
        }
    }

    int pop() {
        if (!isEmpty()) {
            return stack[tos--];
        }
        return -1;
    }

    int top() {
        if (!isEmpty()) {
            return stack[tos];
        }
        return -1;
    }
}
