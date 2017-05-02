/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.io.File;
import java.io.FileNotFoundException;



/**
 *
 * @author Krag
 */
public class AppDriver {
    static private File input = new File("DATAIN.txt");
    static private File search = new File("SEARCH.txt");
    static private File disk;
    static private HashTable h = new HashTable();
    public static void main(String[] args) throws FileNotFoundException {
       
       h.initialize();
       h.RestoreHTtoMem(input);
       h.GenerateStatReport("BeforeReport");
       disk = h.WriteHTtoDisk();
       h.initialize();
       h.RestoreHTtoMem(disk);
       h.GenerateStatReport("AfterReport");
       h.SearchHT(search);
       System.out.println("Average collisions per bucket: " + h.avgOverflow());
       System.out.println("Total collisions: " + h.totalOverflow());
               
    }
    
    


}