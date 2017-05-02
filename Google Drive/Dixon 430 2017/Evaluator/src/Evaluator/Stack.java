/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluator;

/**
 *
 * @author user
 */
public class Stack extends List {
    Stack()
    {
    }
    
    Stack(List a)
    {
        setHead(a.head());
        counter = a.getCounter();
    }



    

    
    public void push(GenericItemType a)
    {
        insertToHead(a);
    }
    
    public GenericItemType pop()
    {
        if(head != null)
        {
        GenericItemType temp = head().getData();
        remove(0);
                return temp;
        }
        return null;

        

        
        
    }
    
    
    public GenericItemType showTop()
    {
        if(head != null)
        return head().getData();
        
        return null;
    }
    
    public void displayStack()
    {
        displayNodes();
    }
}
