import java.util.*;
import java.lang.*;
import java.io.*;
public class findUniqueElement {
    //{ Driver Code Starts
//Initial Template for Java




        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while(t-->0)
            {
                StringTokenizer stt = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(stt.nextToken());
                int k = Integer.parseInt(stt.nextToken());

                int a[] = new int[(int)(n)];
                String inputLine[] = br.readLine().trim().split(" ");
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(inputLine[i]);
                }
                System.out.println(findUnique(a, n, k));

            }
        }


// } Driver Code Ends


//User function Template for Java

        public static int findUnique(int a[], int n, int k)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
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
            }
            //find the unique element
            for(int i =0; i<n; i++){
                //if the number of occurrence is not equal to k (*n) times, return that element
                if(map.get(a[i])%k != 0){
                    return a[i];
                }
            }
            return -1;
        }
}
