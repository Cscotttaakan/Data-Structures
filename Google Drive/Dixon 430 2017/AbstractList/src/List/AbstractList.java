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
public class AbstractList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerDataItem a = new IntegerDataItem(1);
        IntegerDataItem b = new IntegerDataItem(53);
        IntegerDataItem c = new IntegerDataItem(5);
        IntegerDataItem d = new IntegerDataItem(27);
        IntegerDataItem f = new IntegerDataItem(32);
        IntegerDataItem g = new IntegerDataItem(15);
        
        StringDataItem l = new StringDataItem("Craig");
        StringDataItem m = new StringDataItem("Jason");
        StringDataItem n = new StringDataItem("Jarid");
        StringDataItem s = new StringDataItem("josue");
        StringDataItem o = new StringDataItem("thomas");
        StringDataItem p = new StringDataItem("Oscar");
        List linked = new List();
        Stack st = new Stack();
        Queue q = new Queue();
        
        linked.initialize();
        linked.insertToTail(a);
        
        linked.insertToHead(c);
        linked.insertToMiddle(d);
        linked.insertToHead(f);
        linked.insertToTail(b);
        linked.insertToHead(g);
        
        System.out.println("\n\nSearch for number " + b.get() + " in list, is it found?"+ linked.search(b) +"\n");
        linked.displayNodes();

        
        linked.sortAscending();
        linked.displayNodes();

        linked.insertToMiddle(a);
        linked.displayNodes();
        
        linked.sortDescending();
        linked.displayNodes();
        
        
        
        linked.initialize();
        
        linked.insertToHead(l);
        linked.insertToMiddle(m);
        linked.insertToTail(n);
        linked.insertToHead(s);
        linked.insertToHead(o);
        linked.insertToHead(p);
        
        linked.displayNodes();
        linked.sortDescending();
        
        linked.displayNodes();
        linked.sortAscending();
        linked.displayNodes();
        
        st.initialize();
        st.push(a);
        st.push(b);
        st.push(c);
        st.push(d);
        
        st.displayStack();
        st.pop();
        st.pop();
        st.displayStack();
        
        
        q.initialize();
        q.enqueue(m);
        q.enqueue(p);
        q.enqueue(n);
        q.enqueue(o);
        q.enqueue(l);
        
        q.displayQueue();
        
        System.out.println("Dequeue twice: ");
        q.dequeue();
        q.dequeue();
        
        q.sortAscending();
        q.displayQueue();
        
        q.sortDescending();
        q.displayNodes();
        
        // TODO code application logic here
    }
    
}
