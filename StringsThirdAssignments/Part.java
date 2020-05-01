
/**
 * Part 1 2 3
 * 
 * @Sisi Huang
 * @05.01.2020
 */

import edu.duke.*;

public class Part {
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

    public StorageResource getAllGenes(String dna){
        int pos = 0;
        int count = 0;
        StorageResource geneList = new StorageResource();
        while(true){
            String currgene = findGene(dna);
            if(currgene.isEmpty()){
                break;
            }else{
                count++;
                System.out.println("Gene" + count + " : " + currgene);
                geneList.add(currgene);
                pos = dna.indexOf(currgene);
                dna = dna.substring(pos + currgene.length());
                // System.out.println("Generemain" + count + " : " + dna);
               
            }
        }
        return geneList;
    }
    
    public void testPrintAllGenes(){
        // startCodon: ATG stopCodon: TAA TAG TGA
        //                            v  v  v  v  v  v     v  v  v  v  v
        String dna = "GTATTTAAACTAATAAATGTATTTGAACTAGTAACGAATGTATTTAAACTAA";
        StorageResource genes = getAllGenes(dna);
        System.out.println("StorageResource");
        for (String g: genes.data()){
            System.out.println(g);
        }

    }
    
    public float cgRatio(String dna){
        int count = 0, pos = 0;
        int dnalen = dna.length();
        while(true){
            int posC = dna.indexOf("C",pos), posG = dna.indexOf("G",pos);
            if(posC != -1 && posG != -1){
                pos = Math.min(dna.indexOf("C",pos), dna.indexOf("G",pos));
            }else{
                pos = Math.max(dna.indexOf("C",pos), dna.indexOf("G",pos));
            }
            
            if(pos == -1) break;
            count++;
            pos++;
        }
        return (float)count/dnalen;
    }
    
    public int countCTG(String dna){
        int count = 0;
        int pos = 0;
        while(true){
            pos = dna.indexOf("CTG", pos);
            if(pos == -1) break;
            count++;
            pos += 3;
        }
                
        return count;
    }
    
    public void test(){
        String dna = "ATGCCATAG";
        System.out.println(cgRatio(dna));
        dna = "CTGGGCTGT";
        System.out.println(countCTG(dna));
        
    }
    
    
    public void processGenes(StorageResource genes){
        System.out.println("print all the Strings in sr that are longer than 9 characters");
        int count = 0;
        for (String g: genes.data()){
            if(g.length() > 9){
                count++;
                System.out.println("Gene " + count + ": " + g);
                
            }
        }
        
        System.out.println("print the number of Strings in sr that are longer than 60 characters");
        System.out.println("The number is " + count);
        
        System.out.println("print the Strings in sr whose C-G-ratio is higher than 0.35");
        count = 0;
        for (String g: genes.data()){
            if(cgRatio(g) > 0.35){
                count++;
                System.out.println("Gene " + count + ": " + g);
                
            }
        }
        
        System.out.println("print the number of strings in sr whose C-G-ratio is higher than 0.35");
        System.out.println("The number is " + count);
        
        System.out.println("print the length of the longest gene in sr");
        String longGene = "";
        int maxlen = 0;
        
        for (String g: genes.data()){
            
            if(g.length() > maxlen){
                maxlen = g.length();
                longGene = g;
            }
        }
        
        System.out.println("The longest gene is " + longGene);
        
    }
        
    public void testProcessGenes(){
        System.out.println("testProcessGenes");
        if(true){
            String dna = "GTATTTAAACTAATAAATGTAGAACTAGTAACGAATGTATTTAAACTAACCATGCCCCCGTAG";
            StorageResource genes = getAllGenes(dna);
            processGenes(genes);
        }
        
        if(false){
            // Only one gene in brca1line.fa? Whether something wrong?
            FileResource fr = new FileResource("brca1line.fa");
            String dna = fr.asString();
            StorageResource genes = getAllGenes(dna.toUpperCase());
            processGenes(genes);
        }
        
       
    }
}
