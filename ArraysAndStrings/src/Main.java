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
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.print(queue.dequeue());
        queue.enqueue(6);
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
    }
}
