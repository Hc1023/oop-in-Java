
/**
 * Part 3: How Many Genes?
 * 
 * @Sisi Huang
 * @04.26.2020
 */

public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopIndex = startIndex+3;
        while(true){
            stopIndex = dna.indexOf(stopCodon, stopIndex);
            if(stopIndex == -1) break;
            int diff = stopIndex - startIndex;
            if(diff % 3 == 0){
                return stopIndex;
            }else{
                stopIndex ++;
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        //          0  3  6  9  12 15
        String a = "ATGTATTTAAACTAATAA";
        int res = findStopCodon(a, 0, "TAA");
        if(res != 12) System.out.println("Error at 12");
        a = "GTATATTTAAACTATAA";
        res = findStopCodon(a, 0, "TAA");
        if(res != 17) System.out.println("Error at 17");
        System.out.println("Test finished");
    }
    
    public String findGene(String dna){
        int index = dna.indexOf("ATG");
        if (index == -1) return "";
        int stoptaa = findStopCodon(dna, index, "TAA");
        int stoptag = findStopCodon(dna, index, "TAG");
        int stoptga = findStopCodon(dna, index, "TGA");
        int minidx = Math.min(stoptaa, Math.min(stoptag, stoptga));
        if (minidx == dna.length()) return "";
        return dna.substring(index, minidx+3);
    }
        
    public int countGenes(String dna){
        int pos = 0;
        int count = 0;
        while(true){
            String currgene = findGene(dna);
            if(currgene.isEmpty()){
                break;
            }else{
                count++;
                System.out.println("Gene" + count + " : " + currgene);
                pos = dna.indexOf(currgene);
                dna = dna.substring(pos + currgene.length());
                // System.out.println("Generemain" + count + " : " + dna);
            }
        }
        return count;
    }
    
    public void testCountGenes(){
        // startCodon: ATG stopCodon: TAA TAG TGA
        //                            v  v  v  v  v  v     v  v  v  v  v
        String dna = "GTATTTAAACTAATAAATGTATTTGAACTAGTAACGAATGTATTTAAACTAA";
        int count = countGenes(dna);
        System.out.println("There are total number of " + count + " genes");
    }
}
