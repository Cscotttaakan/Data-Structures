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
public class BUCKET {
    private SLOT[] container = new SLOT[3];
    private short COUNTER = 0;
    private short OVERFLOW = 0;
    
    BUCKET()
    {
        for(int i = 0; i < container.length; i++)
        {
            container[i] = new SLOT();
        }
    }
    
    BUCKET(SLOT[] n)
    {
        container = n;
    }
    
    void setSLOT (STR10 key, STR20 data, short slotIndex)
    {
        container[slotIndex].setKEY(key);
        container[slotIndex].setDATA(data);
    }
    
    SLOT[] getSLOT()
    {
        return container;
    }
    
    STR10 getKEY(short slotIndex)
    {
        return container[slotIndex].getKEY();
    }
    
    STR20 getDATA(short slotIndex)
    {
        return container[slotIndex].getDATA();
    }
    
    void setKEY(STR10 k, short slotIndex)
    {
        container[slotIndex].setKEY(k);
    }
    
    void setDATA(STR20 d, short slotIndex)
    {
        container[slotIndex].setDATA(d);
    }
    
    void insertSLOT(STR10 k, STR20 d)
    {
        container[COUNTER].setKEY(k);
        container[COUNTER].setDATA(d);
        COUNTER++;
    }
    
    void clear()
    {
        COUNTER = 0;
        OVERFLOW = 0;
    }
    
    boolean isFULL()
    {
        if(COUNTER>2)
            return true;
        
        else
            return false;
    }
    
    short getCOUNTER()
    {
        return COUNTER;
    }
    
    void OVERFLOW()
    {
        OVERFLOW++;
    }
    
    short getOVERFLOW()
    {
        return OVERFLOW;
    }
    
    
}
