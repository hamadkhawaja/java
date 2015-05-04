import java.util.ArrayList;

/**
 * Created by Hamad on 04/05/2015.
 */
public class StackOfStacks {
    ArrayList<Stack> stack = new ArrayList<Stack>();
    int size;

    StackOfStacks(int size) {
        this.size = size;
    }

    Stack getLastStack() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }

        return null;
    }

    void push(int element) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(element);
        }
        else {
            Stack s = new Stack(size);
            s.push(element);
            stack.add(s);
        }
    }

    int pop() {
        Stack last = getLastStack();
        if (last != null) {
            int val = last.pop();
            if (last.isEmpty()) {
                stack.remove(last);
            }
            return val;
        }

        return -1;
    }
}
