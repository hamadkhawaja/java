public class Main {


    public static void main(String[] args) {
        TripleStack stack = new TripleStack(100);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(0, 3);
        stack.push(0, 4);

        stack.push(1, 4);
        stack.push(1, 3);
        stack.push(1, 2);
        stack.push(1, 1);

        stack.push(2, 4);
        stack.push(2, 5);
        stack.push(2, 6);
        stack.push(2, 2);

        System.out.print("Stack 0: ");
        System.out.print(stack.pop(0));
        System.out.print(stack.pop(0));
        System.out.print(stack.pop(0));
        System.out.print(stack.pop(0));
        System.out.println("");

        System.out.print("Stack 1: ");
        System.out.print(stack.pop(1));
        System.out.print(stack.pop(1));
        System.out.print(stack.pop(1));
        System.out.print(stack.pop(1));
        System.out.println("");

        System.out.print("Stack 2: ");
        System.out.print(stack.pop(2));
        System.out.print(stack.pop(2));
        System.out.print(stack.pop(2));
        System.out.print(stack.pop(2));
        System.out.println("");

    }
}
