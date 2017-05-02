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
public class STR20 {
    private char[] key = new char[20];
    
    STR20()
    {
        
    }
    
    STR20(String n)
    {
        key = n.toCharArray();
    }
    
    STR20(char[] a)
    {
        key = a;
    }
    
    STR20 (STR20 n)
    {
        key = n.get();
    }
    
    void set (char[] n)
    {
        key = n;
    }
    
    void set (String n)
    {
        key = n.toCharArray();
    }
    
    char[] get()
    {
        return key;
    }
    
    String string(){
        return new String(key);
    }
}
