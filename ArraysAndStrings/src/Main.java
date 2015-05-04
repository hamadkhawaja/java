public class Main {


    public static Stack sortStack(Stack main) {
        Stack sorted = new Stack(main.size);
        while (!main.isEmpty()) {
            int temp = main.pop();
            while (!sorted.isEmpty() && sorted.top() < temp) {
                main.push(sorted.pop());
            }

            sorted.push(temp);
        }
        return sorted;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        stack = sortStack(stack);

        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
        System.out.print(stack.pop() + " ");
    }
}
