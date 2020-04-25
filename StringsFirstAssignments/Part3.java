
/**
 * Part 3: Problem Solving with Strings
 * 
 * @Sisi Huang
 * @04.25.2020
 */
import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int idx = -1, count = 0;
        while(true){
            idx++;
            idx = stringb.indexOf(stringa, idx);
            if(idx != -1){
                count++;
            }else{
                break;
            }
        }
        if(count >= 2){
            return true;
        }else{
            return false;
        }
    }
    
    public String lastPart(String stringa, String stringb){
        int idx = stringb.indexOf(stringa);
        if(idx == -1){
            return stringb;
        }
        idx += stringa.length();
        return stringb.substring(idx);        
    }
    
    public void testing(){
        System.out.println("NEW");
        String stra = "by", strb = "A story by Abby Long";
        //stra = "a"; strb = "banana";
        //stra = "atg"; strb = "ctgtatgta";
        boolean res = twoOccurrences(stra, strb);
        System.out.println("stra: " + stra + "; strb: " + strb);
        System.out.println("twoOccurrences: " + res);
        stra = "an"; strb = "banana";
        String lastprt = lastPart(stra, strb);
        System.out.println("The part of the string after " + stra + " in " 
            + strb + " is " + lastprt);
        stra = "zoo"; strb = "forest";
        lastprt = lastPart(stra, strb);
        System.out.println("The part of the string after " + stra + " in " 
            + strb + " is " + lastprt);
    }
}
