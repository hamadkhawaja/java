/**
 * Created by Hamad on 04/05/2015.
 */
public class MyQueueUsingStacks {
    Stack stack;
    int size;
    MyQueueUsingStacks(int size) {
        stack = new Stack(size);
        this.size = size;
    }

    boolean isFull(){
        return stack.isFull();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }

    void enqueue(int element) {
        stack.push(element);
    }

    int dequeue() {
        Stack temp = new Stack(size);
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        if (temp.isEmpty()) {
            return -1;
        }

        int return_val = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return return_val;
    }

}
