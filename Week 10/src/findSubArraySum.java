import java.io.*;
import java.util.*;

public class findSubArraySum {
    //{ Driver Code Starts
//Initial Template for Java



        public static void main(String args[])throws IOException
        {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0)
            {
                int N = Integer.parseInt(read.readLine());
                String input_line[] = read.readLine().trim().split("\\s+");
                int Arr[]= new int[N];
                for(int i = 0; i < N; i++)
                    Arr[i] = Integer.parseInt(input_line[i]);
                int k = Integer.parseInt(read.readLine());

                System.out.println(findSubArraySum(Arr, N, k));
            }
        }

// } Driver Code Ends


//User function Template for Java


        static int findSubArraySum(int Arr[], int N, int k)
        {
            // code here
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,1);

            int ans=0;
            int sum=0;

            for(int i=0; i<Arr.length; i++){
                sum+=Arr[i];
                if(map.containsKey(sum-k)){
                    ans+=map.get(sum-k);
                }
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
            return ans;
        }

}
