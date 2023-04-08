package Queue;
import java.util.LinkedList;
import java.util.Queue;
public class RecentCalls {
    public static class RecentCounter {

        public RecentCounter() {
            time = new LinkedList<Integer>();
        }

        public int ping(int t) {
            time.add(t);
            while (time.peek() < t - 3000) {
                time.poll();
            }
            return time.size();
        }

        private final Queue<Integer> time;
    }
    public static class Main{
        public static void main(String[] args){
            RecentCounter RecentCounter = new RecentCounter();
            int param_1 = RecentCounter.ping(1);
            int param_2 = RecentCounter.ping(100);
            int param_3 = RecentCounter.ping(3001);
            int param_4 = RecentCounter.ping(3002);
            System.out.println(param_1);
            System.out.println(param_2);
            System.out.println(param_3);
            System.out.println(param_4);
        }
    }

}
