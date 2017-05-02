/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class BTreeNode extends GenericItemType{
    private StringDataItem data = new StringDataItem();
    BTreeNode lst;
    BTreeNode rst;
    int height;
    
    BTreeNode()
    {
        lst = null;
        rst = null;
    }
    
    BTreeNode(String a)
    {
        data.set(a);
        lst = null;
        rst = null;
    }
    
    BTreeNode(StringDataItem a)
    {
        data.set(a.get());
        lst = null;
        rst = null;
    }
    
    StringDataItem getData()
    {
        return data;
    }
    
    void setData(StringDataItem a)
    {
        data.set(a.get());
    }
    
    
    @Override
    boolean isLess(GenericItemType a)
    {
        return data.isLess((StringDataItem) a);
    }
    
    @Override
    boolean isEqual(GenericItemType a)
    {
        return data.isEqual((StringDataItem) a);
    }
    
    @Override
    boolean isGreater(GenericItemType a)
    {
        return data.isGreater((StringDataItem) a);
    }
    
}
