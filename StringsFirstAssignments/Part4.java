
/**
 * Part 4: Finding Web Links
 * 
 * @Sisi Huang
 * @04.25.2020
 */
import edu.duke.*;
import java.io.*;

public class Part4 {
    public void test(){
         System.out.println("NEW");
         URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
         for (String s : ur.words()) {
             String sLower = s.toLowerCase();
             int pos = sLower.indexOf("youtube.com");
             if (pos != -1){
                 int beg = s.lastIndexOf("\"",pos);
                 int end = s.indexOf("\"",pos+1);
                 System.out.println(s.substring(beg+1,end));
             }
                
         }
    }

}
