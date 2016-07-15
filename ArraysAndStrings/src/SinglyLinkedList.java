/**
 * Created by Hamad on 7/13/2016.
 */
public class SinglyLinkedList<T> {
    private SinglyListNode<T> head;
    public int size;

    SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(T element) {
        SinglyListNode<T> node = new SinglyListNode<>(element);
        if (head == null) {
            head = node;
            node.next = null;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void printList() {
        SinglyListNode<T> ptr;
        ptr = head;
        while (ptr != null) {
            System.out.print(ptr.element + " ");
            ptr = ptr.next;
        }
    }

    private SinglyListNode<T> reverseList(SinglyListNode<T> head) {
        SinglyListNode<T> current = head;
        SinglyListNode<T> previous = null;
        SinglyListNode<T> next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public void reverseList() {
        head = reverseList(head);
    }

    private  SinglyListNode reverseLinkedListRecursive(SinglyListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        SinglyListNode remaining = reverseLinkedListRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    public void reverseLinkedListRecursive() {
        head = reverseLinkedListRecursive(head);
    }

    public boolean listHasLoop() {
        SinglyListNode slowPtr = head;
        SinglyListNode fastPtr = head;
        while (fastPtr != null || fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }

        return false;
    }

    public T findMidValue() {

        SinglyListNode<T> slowPtr = head;
        SinglyListNode<T> fastPtr = head;
        while (fastPtr != null){
            fastPtr = fastPtr.next;
            if (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }

        return  slowPtr.element;
    }


    public boolean isPalindrome() {
        SinglyListNode slowPtr = head;
        SinglyListNode fastPtr = head;

        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if (fastPtr != null && fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }

        slowPtr = reverseList(slowPtr);

        SinglyListNode ptr1 = head;
        SinglyListNode ptr2 = slowPtr;
        boolean isPalindrome = true;
        while (ptr1 != slowPtr && ptr1 != null && ptr2 != null) {
            if (ptr1.element != ptr2.element) {
                isPalindrome = false;
                break;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        slowPtr = reverseList(slowPtr);

        return isPalindrome;
    }

    public SinglyListNode<T> nthFromLastNode(int n)
    {
        SinglyListNode<T> firstPtr = head;
        SinglyListNode<T> secondPtr = head;

        for (int i = 0; i < n && firstPtr != null; i++) {
            firstPtr = firstPtr.next;
        }

        if (firstPtr == null) {
            // Size of list is less than n.
            return null;
        }

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }

}
