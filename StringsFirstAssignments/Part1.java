/**
 * Part 1: Finding a Gene - Using the Simplified Algorithm
 * 
 * @Sisi Huang
 * @04.25.2020
 */
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        System.out.println("start is: " + start);
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start+3);
        System.out.println("stop is: " + stop);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    public void testGene(){
        String d = "CCCATGGGGTTTGAATAATAATAG";
        String resultd = findSimpleGene(d);
        System.out.println("DNA is: " + d);
        System.out.println("Gene is: " + resultd);
        
    }
    public void testSimpleGene(){
        String a = "TTGAATAGTAA";// DNA with no “ATG”, 
        String b = "TACATGAGTATAG";//DNA with no “TAA”, 
        String c = "ACCTGGACCTGA";//DNA with no “ATG” or “TAA”, 
        String d = "CCCATGGGGTTTGAATAATAATAG";//DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), 
        String e = "CCCATGGGGTTTATAATAATAG";//and DNA with ATG, TAA and the substring between them is not a multiple of 3.
        String resulta = findSimpleGene(a);
        System.out.println("DNA is: " + a);
        System.out.println("Gene is: " + resulta);
        String resultb = findSimpleGene(b);
        System.out.println("DNA is: " + b);
        System.out.println("Gene is: " + resultb);
        String resultc = findSimpleGene(c);
        System.out.println("DNA is: " + c);
        System.out.println("Gene is: " + resultc);
        String resultd = findSimpleGene(d);
        System.out.println("DNA is: " + d);
        System.out.println("Gene is: " + resultd);
        String resulte = findSimpleGene(e);
        System.out.println("DNA is: " + e);
        System.out.println("Gene is: " + resulte);
    }

}
