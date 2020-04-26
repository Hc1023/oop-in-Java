
/**
 * Part 2: HowMany - Finding Multiple Occurrences
 * 
 * @Sisi Huang
 * @04.26.2020
 */

public class Part2 {
    public int howMany(String stra, String strb){
        int count = 0, pos = 0;
        while(true){
            pos = strb.indexOf(stra, pos);
            if (pos == -1) break;
            count++;
            pos += stra.length();
        }
        return count;
    }
    
    public void testHowMany(){
        String stra = "GAA", strb = "ATGAACGAATTGAATC";
        System.out.println(howMany(stra, strb));
        stra = "AA"; strb = "ATAAAA";
        System.out.println(howMany(stra, strb));
        stra = "GG"; strb = "ATAAAA";
        System.out.println(howMany(stra, strb));
    }
}
