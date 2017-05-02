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
public class List extends GenericItemType{
    protected int counter;
    protected Node head;
    protected NodeSort sorter;
    List()
    {
        sorter = new NodeSort();
    }
    
    protected void initialize()
    {
        System.out.println("Initializing " + getClass().getName());
        counter = 0;
        head = null;
    }
    
    
    protected void insertToHead(GenericItemType a)
    {
        add(a,0);
    }
    
    protected void insertToMiddle(GenericItemType a)
    {
        if(counter/2 > 0)
        add(a,counter/2 -1);
        
        else
            add(a);
    }
    
    protected void insertToTail(GenericItemType a)
    {
        add(a);
    }
    
    private void add(GenericItemType a)
    {
        Node temp = new Node(a);
        Node current = head;

        if(current != null)
        {
            //System.out.println("First one is not null");
            while(current.hasNext())
            {
                current = current.getNext();
            }
            
            
            current.setNext(temp);
        }
        
        else
        {
            //System.out.println("First is null");
            head = temp;
        }
        
        incrementCounter();
    }
    
    private void add(GenericItemType a, int index)
    {
        Node temp = new Node(a);
        Node current = head;
        int count = 0;

        if(current != null && index >= 0)
        {
            while(current.hasNext() && count != index)
            {
                current = current.getNext();
                count++;
            }
            
            temp.setNext(current.getNext());
            
            current.setNext(temp);
            
            incrementCounter();
        }
        
        else//Add to head if index is 0
        {
            temp.setNext(current);
            head = temp;
            incrementCounter();
        }
    }
    
    
    protected boolean remove(int index)
    {
        if(index >= counter || counter == 0)//no nodes to remove
            return false;


            Node current = head;
            int temp = 0;
            if(current != null && index != 0)
            {
            while(current.hasNext() && temp != index-1)
            {
                current = current.getNext();
                temp++;
            }
            
                current.setNext(current.getNext().getNext());
                decrementCounter();
                return true;
            }
            
            else//remove head
            {
                head = current.getNext();

            }
            
            
            return true;
            

    }
    
    protected int getCounter()
    {
        return counter;
    }
    
    protected void incrementCounter()
    {
        counter++;
    }
    
    protected void decrementCounter()
    {
        counter--;
    }
    
    protected Node head()
    {
        return head;
    }
    
    protected void setHead(Node a)
    {
        head = a;
    }
    
    protected void sortAscending()
    {
        Node temp = head;
        head = (Node) sorter.MergeSortA(temp);
        System.out.println("Sorted Ascending");
    }
    
    protected void sortDescending()
    {
        Node temp= head;
        head = (Node) sorter.MergeSortD(temp);
        System.out.println("Sorted Descending");
    }
    
    public void displayNodes()
    {
        System.out.println("Display nodes");

        Node current = head;
        while(current != null)
        {

            current.displayNode();
            current = current.getNext();
        }
        System.out.println("");
    }
    
    public boolean isEmpty()
    {
        return (counter == 0);
    }
    
    public boolean isFull()
    {
        return (counter > 0);
    }
    
    @Override
    public boolean isLess(GenericItemType a)
    {
        return (counter < ((List) a).getCounter());
    }
    
    @Override
    public boolean isGreater(GenericItemType a)
    {
        return (counter > ((List) a).getCounter());
    }
    
    @Override
    public boolean isEqual(GenericItemType a)
    {
        return (counter == ((List) a).getCounter());
    }
    
    protected boolean search(GenericItemType a)
    {
        Node current = head;
        
        while(current.hasNext())
        {

            
            if(a.isEqual(current.getData()))
            return true;
            
            current = current.getNext();
        }
        
        if(a.isEqual(current.getData()))
            return true;
        
        return false;
    }
}
