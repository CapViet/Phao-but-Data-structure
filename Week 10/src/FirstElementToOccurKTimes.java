import java.io.*;
import java.lang.*;
import java.util.*;

public class FirstElementToOccurKTimes {
    //{ Driver Code Starts



        public static void main (String[] args) throws IOException  {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
                int m = Integer.parseInt(inputLine[1]);
                int[] arr = new int[n];
                inputLine = br.readLine().trim().split(" ");
                for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);


                System.out.println(firstElementKTime(arr, n, m));
            }
        }


// } Driver Code Ends



        public static int firstElementKTime(int[] a, int n, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            //getting the number of occurrences of each key
            for(int i:a)
            {
                if(map.containsKey(i))
                {
                    map.put(i,map.get(i)+1);
                }
                else
                {
                    map.put(i,1);
                }
                //check immediately for the first element to occur k times
                for(int num:map.keySet())
                {

                    if(map.get(num) == k )
                    {
                        return num;
                    }
                }
            }
            return -1;

    }
}
