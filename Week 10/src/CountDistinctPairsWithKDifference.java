import java.util.*;
import java.lang.*;
import java.io.*;

public class CountDistinctPairsWithKDifference {
    //{ Driver Code Starts
//Initial Template for Java


        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String s1 = br.readLine().trim();
                String[] S1 = s1.split(" ");
                String s2 = br.readLine().trim();
                String[] S2 = s2.split(" ");
                int n, k;
                n = Integer.parseInt(S1[0]);
                k = Integer.parseInt(S1[1]);
                int[] nums = new int[n];
                for(int i = 0; i < S2.length; i++)
                    nums[i] = Integer.parseInt(S2[i]);

                int ans = TotalPairs(nums, k);
                System.out.println(ans);
            }
        }

// } Driver Code Ends


//User function Template for Java


        public static int TotalPairs(int[] nums, int k)
        {
            // Code here
            int count = 0;

            HashMap<Integer,Integer> map = new HashMap<>();
            //putting each element and its frequency of the array into a hash map
            for (int i : nums) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            for(int num : map.keySet()){
                //see if the element num + k (a sign that there are pair with the difference of k) exists
                if(map.containsKey(num+k)){
                    //in the case where k is 0, but the frequency of the element is only 1
                    if(map.get(num)==1 && k==0 ){
                        count=1;
                    }else{
                        count++;
                    }
                }
            }
            return count;

    }
}
