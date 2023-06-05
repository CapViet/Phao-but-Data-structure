//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class DifferenceBetweenOccurences {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }


            System.out.println(findDiff(a, n));

        }
    }

    public static long findDiff(long arr[], long n)
    {
        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        //getting the number of occurrences of each key
        for(long i:arr){
            //if the key alr exist in the hash map, increase the occurrences count by 1
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);

            }
            //if it doesn't exist, add to the hashmap, and mark the occurrence as 1
            else{
                map.put(i,1);
            }
        }
        long min=map.get(arr[0]),max=0;
        //finding the highest and lowest amount of occurrences
        for(long x:arr){
            if(max<map.get(x)){
                max=map.get(x);
            }
            if(min>map.get(x)){
                min=map.get(x);
            }
        }
        return max-min;
    }

}