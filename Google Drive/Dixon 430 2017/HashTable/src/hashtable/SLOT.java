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
public class SLOT {
    private STR10 KEY;
    private STR20 DATA;

    
    SLOT()
    {
        KEY = new STR10();
        DATA = new STR20();
    }
    
    SLOT(STR10 a, STR20 b)
    {
        KEY = new STR10(a);
        DATA = new STR20(b);
    }
    
    SLOT (char[] a, char[] b)
    {
        KEY = new STR10(a);
        DATA = new STR20(b);
    }
    
    STR10 getKEY()
    {
        return KEY;
    }
    
    STR20 getDATA()
    {
        return DATA;
    }
    
    void setKEY(STR10 k)
    {
        KEY.set(k.get());
    }
    
    void setDATA(STR20 d)
    {
        DATA.set(d.get());
    }
    
    
}
