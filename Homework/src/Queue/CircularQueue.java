package Queue;

public class CircularQueue {
    public static class MyCircularQueue {
        private int front;
        private int rear;
        private int[] arr;
        private int cap;

        private int next(int i) { // to get next index after i in circular queue
            return (i + 1) % cap;
        }

        private int prev(int i) { // to get prev index before i in circular queue
            return (i + cap - 1) % cap;
        }

        // implement a normal queue using array.
        public MyCircularQueue(int k) {
            arr = new int[k];
            cap = k;
            front = -1;
            rear = -1;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (front == -1) {
                front = 0;
                rear = 0;
                arr[rear] = value;
                return true;
            }
            rear = next(rear);
            arr[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            if (front == rear) {
                front = -1;
                rear = -1;
                return true;
            }
            front = next(front);
            return true;
        }

        public int Front() {
            if (front == -1) return -1;
            return arr[front];
        }

        public int Rear() {
            if (rear == -1) return -1;
            return arr[rear];
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return front != -1 && next(rear) == front;
        }
    }
    public static class Main {
        public static void main(String[] args) {
            MyCircularQueue q = new MyCircularQueue(3);
            System.out.println(q.enQueue(1));
            System.out.println(q.enQueue(2));
            System.out.println(q.enQueue(3));
            System.out.println(q.enQueue(4)); // return False, the cap (capacity is only 3)
            System.out.println(q.Rear());
            System.out.println(q.isFull());
            System.out.println(q.deQueue());
            System.out.println(q.enQueue(4));
            System.out.println(q.Rear());
        }
    }

}
