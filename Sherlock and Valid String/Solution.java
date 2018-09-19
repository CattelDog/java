import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isValid(String s){
  
        String valid = "YES";
        char fChar = s.charAt(0);
        int strLen_pre = s.length();
        s = s.replace("" + fChar + "", "");
        int strLen_post = s.length();
        int numChars = strLen_pre - strLen_post;
        boolean canHaveOne = true;
        int charDiff = 0;
        
        while (strLen_post > 0) {
            fChar = s.charAt(0);
            strLen_pre = s.length();
            s = s.replace("" + fChar + "", "");
            strLen_post = s.length();
            charDiff = strLen_pre - strLen_post;    
            if (charDiff != numChars) {
                if ((charDiff == 1 || charDiff == numChars + 1) && canHaveOne) {
                    canHaveOne = false;
                } else {
                    valid = "NO";
                    break;
                }
             
            }
        }
       
        return valid;
        
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
