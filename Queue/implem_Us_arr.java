class CircularQueue {
    int[] arr;
    int front, rear, size, capacity;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue is Full");
            return;
        }
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
} 

public class implem_Us_arr {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Front element: " + q.peek());
    }
}
