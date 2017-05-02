/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

/**
 *
 * @author Krag
 */
public class STR10 {
    private char[] key = new char[10];
    
    STR10()
    {
        
    }
    
    STR10(String n)
    {
        key = n.toCharArray();
    }
    
    STR10(char[] a)
    {
        key = a;
    }
    
    STR10 (STR10 n)
    {
        key = n.get();
    }
    
    void set (char[] n)
    {
        key = n;
    }
    
    char[] get()
    {
        return key;
    }
    
    String string()
    {
        return new String(key);
    }
}
