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
public class List extends GenericItemType{
    protected int counter;
    protected Node head;
    protected Node tail;
    protected NodeSort sorter;
    protected Node indexNode;
    protected int iIndex;
    List()
    {
        sorter = new NodeSort();
        head = new Node();
        head = null;
        iteratorInitialize();
    }
    
    protected void initialize()
    {
        System.out.println("Initializing " + getClass().getName());
        counter = 0;
        head = null;
    }
    
    public void iteratorInitialize()
    {
        indexNode = head;
        iIndex = 0;
    }
    
    public boolean iteratorHasNext()
    {
        if(head != null)
        return indexNode.hasNext();
        
        return false;
    }
    
    public void iteratorNext()
    {
        if(indexNode.hasNext())
        indexNode = indexNode.getNext();
        
        iIndex++;
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
            current.setPrevious(temp.getPrevious());
            tail = temp;
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

        if(current != null && index > 0)
        {
            while(current.hasNext() && count != index)
            {
                current = current.getNext();
                count++;
            }
            
            temp.setNext(current.getNext());
            
            current.setNext(temp);
            current.setPrevious(temp.getPrevious());
            
            incrementCounter();
        }
        
        else//Add to head if index is 0
        {
            temp.setNext(current);
            if(head == null)
            {
                tail = temp;
            }
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
            if(current.hasNext())
            {
                current.getNext().getNext().setPrevious(current);
                current.setNext(current.getNext().getNext());
                decrementCounter();
                return true;
            }
            }
            
            else//remove head
            {
                head = current.getNext();
                current.setPrevious(null);
                decrementCounter();
                return true;
            }
            
            
            return true;
            

    }
    
    protected Node get(int index)
    {
        if(index >= counter || counter == 0)//no nodes to remove
            return null;


            Node current = head;
            int temp = 0;
            if(current != null && index != 0)
            {
            while(current.hasNext() && temp != index-1)
            {
                current = current.getNext();
                temp++;
            }
                Node x = current.getNext();
                current.getNext().getNext().setPrevious(current);
                current.setNext(current.getNext().getNext());
                decrementCounter();
                return x;
            }
            
            else//remove head
            {
                Node x = head;
                head = current.getNext();
                current.setPrevious(null);
                decrementCounter();
                return x;

            }
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
    
    protected void setTail(Node a)
    {
        tail = a;
    }
    
    protected Node getTail()
    {
        return tail;
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

        Node current = head;
        //System.out.print("The first item is the head.");
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
