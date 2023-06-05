import java.io.*;
import java.util.*;
import java.lang.*;

public class GroupingValue {
    //{ Driver Code Starts
//Initial Template for Java



        public static void main(String args[])throws IOException{
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                int N = Integer.parseInt(read.readLine());
                String input_line[] = read.readLine().trim().split("\\s+");
                int arr[]= new int[N];
                for(int i = 0; i < N; i++)
                    arr[i] = Integer.parseInt(input_line[i]);
                int K = Integer.parseInt(read.readLine());
                System.out.println(isPossible(N, arr, K));
            }
        }


// } Driver Code Ends


//User function Template for Java


        static int isPossible(int N, int arr[], int K)
        {
            HashMap<Integer,Integer> map = new HashMap<>();
            //getting the number of occurrences of each key, again
            for(int i:arr)
            {
                if(map.containsKey(i))
                {
                    map.put(i,map.get(i)+1);
                }
                else
                {
                    map.put(i,1);
                }
            }

            for(int num:map.keySet())
            {
                //if the occurrence count of a key is larger than 2*K, it can't be divided to K groups
                //since there can only be at most 2 of the same keys, K groups can only have a max of 2*K of the same key
                if(map.get(num)> (2*K))
                {
                    return 0;
                }
            }
            return 1;
        }

}
