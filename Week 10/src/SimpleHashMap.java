import java.util.HashMap;

class SimpleHashMap{
    private int[] keys;
    private int[] values;
    private int n;
    private int cap = 5000 ;
    public SimpleHashMap() {
        this.keys = new int[cap];
        this.values = new int[cap];
    }

    public void put(int key, int value) {
        int index = indexOfKey(key);
        if(index == -1){
            values[n] = value;
            keys[n] = key;
            n++;
        }
        else{
            values[index] = value;
        }
    }

    public int indexOfKey(int key){
        for(int i =0; i < n; i ++){
            if(keys[i] == key)
                return i;
        }
        return -1;
    }

    public int get(int key) {
        int index =  indexOfKey(key);
        if(index == -1){
            return -1;
        }
        return values[index];
    }

    public void remove(int key) {
        int index = indexOfKey(key);
        if (index != -1){
            for(int i = index; i < n; i ++){
                keys[i] = keys[i + 1];
                values[i] = values[i+1];
            }
            n--;
        }
    }
    public static void main(String[] args){
        SimpleHashMap map = new SimpleHashMap();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        for(int i = 0; i < map.n; i ++){
            System.out.print(map.get(map.keys[i]) + " ");
        }
        map.remove(1);
        System.out.println();
        for(int i = 0; i < map.n; i ++){
            System.out.print(map.get(map.keys[i]) + " ");
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */