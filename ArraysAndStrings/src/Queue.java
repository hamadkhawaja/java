/**
 * Created by Hamad on 04/05/2015.
 */
public class Queue {
    int capacity;
    int size;
    int []queue;
    int front;
    int rear;

    Queue(int size) {
        capacity = size;
        this.size = 0;
        queue = new int[capacity];
        front = 0;
        rear = 0;
    }

    void enqueue(int element) {
        if (size < capacity) {
            if (front == capacity) {
                front = 0;
            }

            queue[front++] = element;
            size++;
        }
    }

    int dequeue() {
        if (size > 0) {
            size--;
            int ret_val = queue[rear++];
            if (rear == capacity) {
                rear = 0;
            }

            return ret_val;
        }

        return -1;
    }

    boolean isFull() {
        return size == capacity;
    }
}
