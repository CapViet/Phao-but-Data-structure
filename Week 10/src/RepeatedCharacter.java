import java.io.*;
import java.util.*;
public class RepeatedCharacter {
    //{ Driver Code Starts
//Initial Template for Java




        public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0)
            {
                String s;
                s = sc.next();


                char res = firstRep(s);
                if (res == '#')
                    System.out.println(-1);
                else
                    System.out.println(res);

            }
        }

// } Driver Code Ends


    //User function Template for Java
    static char firstRep(String S)
        {

            HashMap<Character,Integer> map = new HashMap<>();
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
            //reverse of the non repeating one
            for(int i =0;i<S.length();i++)
            {

                if(map.get(S.charAt(i)) > 1)
                {
                    return S.charAt(i);
                }
            }
            return '#';
        }
}
