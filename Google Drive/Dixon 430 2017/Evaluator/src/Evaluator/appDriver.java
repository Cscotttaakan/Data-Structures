package Evaluator;

import java.io.File;
import java.io.FileNotFoundException;






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
    
    /**
     * @param args the command line arguments
     */
    static private File input = new File("DATAIN.txt");
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Evaluator o = new Evaluator();
        o.runTokenizer();
        o.parser();
        o.evaluatePostfix();
       
    }
    
}
