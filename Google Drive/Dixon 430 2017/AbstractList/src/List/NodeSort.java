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
public class NodeSort extends GenericSort {
    
    NodeSort()
    {
        
    }
    
    @Override
    public GenericItemType ascending(GenericItemType a)
    {

        return MergeSortA((Node) a);
    }
    

    @Override
    public GenericItemType descending(GenericItemType a)
    {

        return MergeSortD((Node) a);
    }
    
    public Node MergeSortA(Node headOriginal)
    {

        if (headOriginal == null || !headOriginal.hasNext())
            return headOriginal;
        
        Node a = headOriginal;
        Node b = headOriginal.getNext();
        
        while((b != null) && (b.hasNext()))
        {
            headOriginal = headOriginal.getNext();
            b = (b.getNext().getNext());
        }
            b = headOriginal.getNext();
            headOriginal.setNext(null);
            
            return mergeA(MergeSortA(a), MergeSortA(b));
        
    }
    
    public Node mergeA(Node a, Node b)
    {
        Node temp = new Node();
        Node header = temp;
        Node c = header;
        
        while((a != null) && (b != null))
        {
            if(a.isLess(b) || a.isEqual(b))
            {
                c.setNext(a);
                c=a;
                a = a.getNext();
            }
            
            else{
                
                c.setNext(b);
                c = b;
                b = b.getNext();
                
            }
        }
        
        c.setNext((a == null) ? b : a);
        
        return header.getNext();
        
    }
    
    public Node MergeSortD(Node headOriginal)
    {

        if (headOriginal == null || !headOriginal.hasNext())
            return headOriginal;
        
        Node a = headOriginal;
        Node b = headOriginal.getNext();
        
        while((b != null) && (b.hasNext()))
        {
            headOriginal = headOriginal.getNext();
            b = (b.getNext().getNext());
        }
            b = headOriginal.getNext();
            headOriginal.setNext(null);
            
            return mergeD(MergeSortD(a), MergeSortD(b));
        
    }
    
    public Node mergeD(Node a, Node b)
    {
        Node temp = new Node();
        Node header = temp;
        Node c = header;
        
        while((a != null) && (b != null))
        {
            if(a.isLess(b) || a.isEqual(b))
            {
                c.setNext(b);
                c = b;
                b = b.getNext();
            }
            
            else{
                
                
                c.setNext(a);
                c=a;
                a = a.getNext();
                
            }
        }
        
        c.setNext((a == null) ? b : a);
        
        return header.getNext();
        
    }
    
}
