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
public class Node extends GenericItemType {
    private Node NEXT = null;
    private GenericItemType DATA;
    
    Node()
    {
        
    }
    
    Node(GenericItemType a)
    {
        DATA = a;
    }
    
    Node(GenericItemType a, Node b)
    {
        NEXT = b;
        DATA = a;
    }
    

    GenericItemType getData()
    {
        return DATA;
    }
    

    void setData(GenericItemType a)
    {
        DATA = a;
    }
    
    Node getNext()
    {
        return NEXT;
    }
    
    void setNext(Node a)
    {
        NEXT = a;
    }
    
    boolean hasNext()
    {
        return (NEXT != null);
    }
    
    @Override
    public boolean isLess(GenericItemType a)
    {
        return DATA.isLess(((Node) a).getData());
    }
    
    @Override
    public boolean isGreater(GenericItemType a)
    {
        return DATA.isGreater(((Node) a).getData());
    }
    
    @Override
    public boolean isEqual(GenericItemType a)
    {
        return DATA.isEqual(((Node) a).getData());
    }
    
    public void displayNode()
    {
        System.out.println(DATA.toString());
    }
}
