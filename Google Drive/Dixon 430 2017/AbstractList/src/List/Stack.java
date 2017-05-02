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
public class Stack extends List {
    Stack()
    {
        System.out.println("Initialize");
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
        GenericItemType temp = head().getData();
        remove(0);

        return temp;
        
    }
    
    
    public GenericItemType showTop()
    {
        return head().getData();
    }
    
    public void displayStack()
    {
        displayNodes();
    }
}
