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
public class Queue extends List {
    
    Queue()
    {
        
    }
    
    Queue(List a)
    {
        setHead(a.head());
        counter = a.getCounter();
        
    }
    
    public void enqueue(GenericItemType a)
    {
        insertToTail(a);
    }
    
    public GenericItemType dequeue()
    {
        Node temp = head;
        remove(0);
        return temp;
    }
    
    public void displayQueue()
    {
        displayNodes();
    }
         
}
