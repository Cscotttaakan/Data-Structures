/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

/**
 *
 * @author user
 */
public class IntegerDataItem extends GenericItemType {
    private int value;
    
    public IntegerDataItem()
    {
        
    }
    
    public IntegerDataItem(int i)
    {
        set(i);
    }
    
    public IntegerDataItem(IntegerDataItem i)
    {
        value = i.get();
    }
    
    public int get()
    {
        return value;
    }
    
    public void set(int i)
    {
        value = i;
    }
    
    @Override
    public boolean isLess(GenericItemType a)
    {
        return(value < ((IntegerDataItem) a).get());
    }
    
    @Override
    public boolean isGreater(GenericItemType a)
    {
        return(value > ((IntegerDataItem) a).get());
    }
    
    @Override
    public boolean isEqual(GenericItemType a)
    {
        return(value == ((IntegerDataItem) a).get());
    }
    
    @Override
    public String toString()
    {
        return "" + value;
    }
}
