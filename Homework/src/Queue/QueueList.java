package Queue;

public class QueueList {
    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }
    class MyQueue
    {
        QueueNode front, rear;

        //Function to push an element into the queue.
        void push(int a)
        {
            // Create a new LL node
            QueueNode temp = new QueueNode(a);

            // If queue is empty, then new node is front and
            // rear both
            if (this.rear == null) {
                this.front = this.rear = temp;
                return;
            }

            // Add the new node at the end of queue and change
            // rear
            this.rear.next = temp;
            this.rear = temp;
            // Your code here
        }

        //Function to pop front element from the queue.
        int pop()
        {
            // If queue is empty, return NULL.
            if (this.front == null)
                return -1;

            // Store previous front and move front one node
            // ahead
            QueueNode temp = this.front;
            this.front = this.front.next;

            // If front becomes NULL, then change rear also as
            // NULL
            if (this.front == null)
                this.rear = null;
            // Your code here
            return temp.data;
        }
    }
}
