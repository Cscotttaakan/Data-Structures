
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class appDriver {
    static private File data = new File("Automaton.txt");
    /**
     * @param args the command line arguments
     */
    public static BTree tree = new BTree();
    public static StringDataItem a = new StringDataItem("Isolation");
    public static StringDataItem b = new StringDataItem("Normalization");
    public static StringDataItem c = new StringDataItem("Distributed Processing");
    public static void main(String[] args) throws IOException {
        readProcessFile();
        tree.Traverse();
        System.out.println("_________________");
        tree.TraverseReverse();
        System.out.println(tree.delete(a));
        System.out.println(tree.delete(b));
        System.out.println(tree.delete(c));
        System.out.println("Post deletion: ");
        System.out.println("_________________");
        tree.Traverse();
        System.out.println("_________________");
        tree.TraverseReverse();
    }
    
    
    
    
    
    
    public static void readProcessFile() throws FileNotFoundException, IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader(data))) {
    for(String line; (line = br.readLine()) != null; ) {
        tree.insert(new StringDataItem(line));
    }
    // line is not visible here.
    br.close();
    }       catch (IOException ex) {
            Logger.getLogger(appDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
