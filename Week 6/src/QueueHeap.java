public class QueueHeap {

        int[] arr;
        int capacity;
        int size;
        QueueHeap(int cap) {
            size = 0;
            capacity = cap;
            arr = new int[cap];
        }
        int getParent(int i){
            return (i - 1) /2;
        }
        public int getLeftChild(int i){
            return (2 * i + 1);
        }

        public int getRightChild(int i){
            return (2 * i + 2);
        }
        public void insert(int value){
            if(size == 50)
            return;
            decreaseKey(this.size, value);
            size++;
        }
        public void upHeap(int i){
            while(i > 0 && arr[i] > arr[getParent(i)]){
                swap(i, getParent(i));
                i = getParent(i);
            }
        }
        public void downHeap(int i){ //MinHeapify method
           int l = getLeftChild(i);
           int r = getRightChild(i);
           int index =i;
           if(l < size && arr[l] > arr[index]){
               index = l;
           }
            if(r < size && arr[r] > arr[index]){
                index = r;
            }
            if(i != index){
                swap(i, index);
                downHeap(i);
            }
        }
        public void deleteKey(int i) {
        // Your code here.
            if(size<=0 || size <= i)
                return;
            this.decreaseKey(i, Integer.MIN_VALUE);
            this.getMin();
        }
        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        public int getMax(){
            swap(0, size-1);
            int t = arr[size -1];
            this.size--;
            downHeap(0);
            return t;
        }
        public int getMin(){ //extract min method
            if (size<=0) return -1;
            int k = arr[0];
            arr[0]=arr[--size];
            downHeap(0);
            return k;
        }

        public void print(){
            for(int i =0; i < size; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        void decreaseKey(int i, int new_val)
        {
            arr[i] = new_val;
            while (i != 0 && arr[getParent(i)] > arr[i]) {
                swap(getParent(i), i);
                i = getParent(i);
            }
        }
        public int getValue(int i){
            return this.arr[i];
        }

        public static void main(String[] args){
            QueueHeap q = new QueueHeap(50);
            q.insert(4);
            q.insert(2);
            System.out.println(q.getMin());
            q.insert(6);
            q.deleteKey(0);
            System.out.println(q.getMin());
            System.out.println(q.getMin());//no elements left in the array, prints -1
    }
}
