/**
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * 
 * @Sisi Huang
 * @04.25.2020
 */
import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String dna2=dna.toUpperCase();
        int start = dna2.indexOf(startCodon);
        //System.out.println("start is: " + start);
        if (start == -1) {
            return "";
        }
        int stop = dna2.indexOf(stopCodon, start+3);
        //System.out.println("stop is: " + stop);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
    
    public void testGene(){
        String d = "CCCATGGGGTTTGAATAATAATAG";
        d = d.toLowerCase(); // check lowercase
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String resultd = findSimpleGene(d, startCodon, stopCodon);
        System.out.println("DNA is: " + d);
        System.out.println("Gene is: " + resultd);
        
    }
}
