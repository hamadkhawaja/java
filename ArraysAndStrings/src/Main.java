import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

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
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.printList();
        System.out.println(list.isPalindrome());
        list.printList();
        System.out.println();
        System.out.println(list.findMidValue());
    }
}
