public class SimpleLinkedList <T>{
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;
    public void add(T data) {
// Thêm phần tử vào đầu danh sách
        Node p = new Node();
        p.data = data;
        p.next =  null;
        n++;
        if( top == null && bot == null) {
            top = p;
            bot = p;
        }
        else{
            p.next = top;
            top = p;
        }
    }
    public void addBot(T data) {
// Thêm phần tử vào cuối danh sách
        Node p = new Node();
        p.data = data;
        p.next =  null;
        n++;
        if( top == null && bot == null) {
            top = p;
            bot = p;
        }
        else{
            bot.next = p;
            bot = p;
        }
    }
    public T get(int i)
    {
// Lấy phần tử ở vị trí thứ i
        Node p = top;
        if (i<0 || i >= n )
            return null;
        for(int j = 0; j < i ; j++){
            p = p.next;

        }
        return p.data;
    }
    public void set(int i, T data)
    {
// Gán giá trị ở vị trí i bằng data
        Node p = top;
        if (i < 0 || i >= n){
            System.out.println("Invalid i");
        }
        else {
            for (int j = 0; j <i; j++){
                p.data = data;
            }
        }
    }
    public boolean isContain(T data) {
// Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node p = top;
        while (p != null){
            if (p.data.equals(data)){
                return true;
            }
            p=p.next;
        }
        return false;
    }
    public int size() {
// Trả lại thông tin số phần tử có trong danh sách
        return n;
    }
    public boolean isEmpty() {
// Kiểm tra danh sách có rỗng hay không?
        if(n == 0){
            return true;
        }
        return false;
    }
    public T removeTop() {
// Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        if(n==0) {
            return null;
        }
        Node p = top;
        top = top.next;
        n--;
        return p.data;
    }
    public T removeBot() {
// Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        if(n==0) {
            return null;
        }
        Node p = bot;
        if (n == 1){
            top = null;
            bot = null;
            n= 0;
            return p.data;
        }
        bot = null;
        n--;
        return p.data;
    }
    public void remove(T data) {
// Xóa tất cả các phần tử có giá trị bằng data
        
    }
}

