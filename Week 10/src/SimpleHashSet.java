public class SimpleHashSet {
        private int[] keys;
        private int n;
        private int cap = 1000000 ;
        public SimpleHashSet() {
            this.keys = new int[cap];
        }

        public void add(int key) {
            int index = indexOfKey(key);
            if(index == -1){
                keys[n] = key;
                n++;
            }
        }
        public int indexOfKey(int key){
            for(int i =0; i < n; i ++){
                if(keys[i] == key)
                    return i;
            }
            return -1;
        }

        public void remove(int key) {
            int index = indexOfKey(key);
            if (index != -1){
                for(int i = index; i < n; i ++){
                    keys[i] = keys[i + 1];
                }
                n--;
            }
        }

        public boolean contains(int key) {
            boolean doesContain = false;
            for(int i = 0; i < n; i ++){
                if(keys[i] == key){
                    doesContain = true;
                    break;
                }
            }
            return doesContain;
        }
        public static void main(String[] args){
            SimpleHashSet set = new SimpleHashSet();
            set.add(1);
            set.add(10);
            set.add(100);
            set.add(1000);
            for(int i = 0; i < set.n; i ++){
                System.out.print(set.keys[i] + " ");
            }
            System.out.println();
            System.out.println("The set contains 1: "+set.contains(1));
            set.remove(1);
            for(int i = 0; i < set.n; i ++){
                System.out.print(set.keys[i] + " ");
            }
            System.out.println();
            System.out.println("The set contains 1: "+set.contains(1));
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

