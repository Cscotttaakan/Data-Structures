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
public class StringDataItem extends GenericItemType {
    private String value;
    
    StringDataItem()
    {
        
    }
    
    StringDataItem(String a)
    {
        value = a;
    }
    
    StringDataItem(StringDataItem a)
    {
        value = a.get();
    }
    
    public String get()
    {
        return value;
    }
    
    public void set(String a)
    {
        value = a;
    }
    
    @Override
    public boolean isLess(GenericItemType a)
    {
        return (value.compareTo(((StringDataItem) a).get()) < 0);
    }
    
    @Override
    public boolean isGreater(GenericItemType a)
    {
        return (value.compareTo(((StringDataItem) a).get()) > 0);
    }
    
    @Override
    public boolean isEqual(GenericItemType a)
    {
        return (value.compareTo(((StringDataItem) a).get()) == 0);
    }
    
    @Override
    public String toString()
    {
        return value;
    }
}
