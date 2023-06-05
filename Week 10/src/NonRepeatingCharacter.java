import java.io.*;
import java.lang.*;
import java.util.*;
public class NonRepeatingCharacter {
    //{ Driver Code Starts
//Initial Template for Java

        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-- > 0)
            {
                String st = sc.next();

                char ans= nonrepeatingCharacter(st);

                if(ans!='$')
                    System.out.println(ans);
                else
                    System.out.println(-1);
            }
        }


// } Driver Code Ends


//User function Template for Java

        //Function to find the first non-repeating character in a string.
        static char nonrepeatingCharacter(String S)
        {
            //Your code here
            HashMap<Character,Integer> map = new HashMap<>();
            //getting the number of occurrences of each key, with the key being the first instance of a character
            for(int i=0;i<S.length();i++)
            {
                if(map.containsKey(S.charAt(i)))
                {
                    map.put(S.charAt(i),map.get(S.charAt(i)) + 1);
                }
                else{
                    map.put(S.charAt(i),1);
                }
            }
            //getting the first non repeating character
            for(int i =0;i<S.length();i++)
            {
                //return the character corresponding with the key that only has 1 occurrence
                if(map.get(S.charAt(i))==1)
                {
                    return S.charAt(i);
                }
            }
            return '$';
        }

}
