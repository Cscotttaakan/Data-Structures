/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krag
 */
public class HashTable {
    private BUCKET[] container = new BUCKET[30];
    final short primaryBUCKETS = 20;
    final short overflowBUCKETS = 10;
    final short overflowINCREMENT = 5;
    
    HashTable()
    {
        for(int i = 0; i < container.length; i++)
        {
            container[i] = new BUCKET();
        }
    }
    
    void initialize()
    {
        for(BUCKET a : container)
            a.clear();
    }
    
    void insertIntoHT(STR10 k, STR20 d)
    {
        int position = HashFunction(k,primaryBUCKETS);
        //System.out.println("Position: " + position);
        if(!container[position].isFULL())//for primary bucket
        container[position].insertSLOT(k, d);
        
        else{//for overflowbucket
            container[position].OVERFLOW();
            position = HashFunction(k,overflowINCREMENT) + primaryBUCKETS;
            if(!container[position].isFULL())//Overflow 20-25
                container[position].insertSLOT(k, d);
            
            else//overflow of overflow 25-30
            {
                position = HashFunction(k,overflowINCREMENT) + primaryBUCKETS + overflowINCREMENT;
                container[position].insertSLOT(k,d);
            }
            
            //System.out.println("Overflow commencing");
            //System.out.println("Overflow position: " + position);
        }
            
    }
    
    int[] search(STR10 k)
    {
        int[] id = new int[2];
        int position = HashFunction(k,primaryBUCKETS);
        //System.out.println("Position: " + position);
        if(searchBucket(k,position))//for primary bucket
        {
            id[0] = position;
            id[1] = returnBucket(k,position);
            return id;
        }
            //search bucket
        else{//for overflowbucket
            
            position = HashFunction(k,overflowINCREMENT) + primaryBUCKETS;
            if(searchBucket(k,position))//Overflow 20-25
            {
                id[0] = position;
                id[1] = returnBucket(k,position);
                return id;
            }
            else//overflow of overflow 25-30
            {
                position = HashFunction(k,overflowINCREMENT) + primaryBUCKETS + overflowINCREMENT;
                if(searchBucket(k,position))
                {
                id[0] = position;
                id[1] = returnBucket(k,position);
                }
                else
                {
                    id[0] = 65;
                    id[1] = 78;
                }
                return id;
            }
            
            //System.out.println("Overflow commencing");
            //System.out.println("Overflow position: " + position);
        
        }
        
    }
    
    private int HashFunction(STR10 key, short tablesize)
    {
        char[] temp = key.get();
        int value = temp[1] + temp[3] + temp[5];
        value = value % tablesize;
        
        return value;
    }
    
    void RestoreHTtoMem(File file) throws FileNotFoundException
    {
        STR10 k = new STR10();
        STR20 d = new STR20();
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
    for(String line; (line = br.readLine()) != null; ) {
        k.set(line.substring(0,10).toCharArray());
        d.set(line.substring(10, 30).toCharArray());
        //System.out.println("K : " + new String(k.get()));
        //System.out.println("D : " +new String(d.get()));
        insertIntoHT(k,d);
        //System.out.println("working");
    }
    // line is not visible here.
    br.close();
    }       catch (IOException ex) {
            Logger.getLogger(AppDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    File WriteHTtoDisk()
    {
         try{
            File r = new File("output.txt");
            FileWriter pw = new FileWriter(r);
            PrintWriter pr = new PrintWriter(pw);

            for(int i = 0; i < container.length; i++)
            {
                for(int s = 0; s < container[i].getCOUNTER(); s++)
                {
                    String a = new String(container[i].getKEY((short) s).get());
                    String b = new String(container[i].getDATA((short) s).get());
                    pr.println(a + b);
                }
            }

            
            pr.close();
            return r;
         }catch(IOException e){}

    
         return new File("error.txt");
    }
    
    void GenerateStatReport(String name)
    {
        try{
            File r = new File(name + ".txt");
            FileWriter pw = new FileWriter(r);
            PrintWriter pr = new PrintWriter(pw);
            String tab = "      ";
            pr.println("Hash Table");
            pr.println("Stat Report");
            for(int i = 0; i < container.length; i++)
            {
                pr.println("Bucket " + (i+1));
                for(int s = 0; s < container[i].getCOUNTER(); s++)
                {
                    
                    String a = new String(container[i].getKEY((short) s).get());
                    String b = new String(container[i].getDATA((short) s).get());
                    pr.println(tab + "Slot " + (s+1) + ": " + (a+b));
                    
                    
                }
                pr.println(tab+ "Counter: " + container[i].getCOUNTER());
                pr.println(tab +"Overflow: " +container[i].getOVERFLOW());
                pr.println("");
                
                
            }

            pr.println("Average collisions: " + avgOverflow());
                pr.println("Total Collisions: " + totalOverflow());
            pr.close();
            
         }catch(IOException e){}

    
    }
    
    void SearchHT(File file)
    {
        STR10 k = new STR10();
        STR20 d = new STR20("");
        int position;
        int slot;
        String tab = "      ";
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            File r = new File("searchResults.txt");
            FileWriter pw = new FileWriter(r);
            PrintWriter pr = new PrintWriter(pw);
            pr.println(tab+ tab +"Search and Retrieval Transactions");
            pr.println("");
            pr.println("Search Key" + tab + "Bucket/Slot" +tab+ "Record");
    for(String line; (line = br.readLine()) != null; ) {
        k.set(line.substring(0,10).toCharArray());
        //System.out.println(new String(k.get()));
        d.set("Record not found");
        int[] id = search(k);
        //System.out.println("Hash position: " + id[0]);
        String ids =new String((id[0]+1)+"/"+(id[1]+1));
        if(id[0] < 65)
        {
        d.set(container[id[0]].getSLOT()[id[1]].getDATA().get());
        String temp = String.format("%5s %6s %-4s %6s %-20s", k.string(),tab, ids, tab, d.string());
        System.out.println(temp);
        pr.println(temp);
        }
        
        else
        {
            
            pr.println(k.string() + tab + "        " + tab + d.string());
        }
        
        
      
        
        
        
       
        
        
        
    }
    pr.close();
    // line is not visible here.
    br.close();
    }       catch (IOException ex) {
            Logger.getLogger(AppDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    int returnBucket(STR10 k, int position)//return slot
    {
        
        for(int i = 0; i < container[position].getCOUNTER(); i++)
        {
            if(Arrays.equals(container[position].getSLOT()[i].getKEY().get(),k.get()))
            {
                return i;
            }
        }
        
        return 0;
    }
    
    boolean searchBucket(STR10 k, int position)//return slot
    {
        
        for(int i = 0; i < container[position].getCOUNTER(); i++)
        {
            if(Arrays.equals(container[position].getSLOT()[i].getKEY().get(),k.get()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    double avgOverflow()
    {
        double initial = 0;
        double total = 0;
        for(int i = 0; i < container.length; i++)
        {
            if(container[i].getCOUNTER() - 1 > 0 && i <= 20)
            {
                
            initial += container[i].getCOUNTER()-1 +container[i].getOVERFLOW();
            total++;
            }   
            
            
        
        
    }
    System.out.println("Total: " + total);
    System.out.println("Initial: " + initial);
         
    return initial/total;
    }
    
    double totalOverflow()
    {
        double initial = 0;

        for(int i = 0; i < container.length; i++)
        {
            if(container[i].getCOUNTER() - 1 > 0 && i <= 20)
            {
                
            initial += container[i].getCOUNTER()-1 +container[i].getOVERFLOW();

            }   
            
            
        
        
    }

         
    return initial;
    }
}