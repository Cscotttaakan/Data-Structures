/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class BTree {
    private BTreeNode root;
    
    BTree()
    {
        
    }
    
    BTree(BTreeNode a)
    {
        root.setData(a.getData());
    }
    
    BTree(BTree a)
    {
        root.setData(a.getRoot().getData());
    }
    
    BTreeNode getRoot()
    {
        return root;
    }
    
    void setRoot(BTreeNode a)
    {
        root = a;
    }
    
    void insert(StringDataItem a)
    {
        if(root == null)
        {
            root = new BTreeNode(a);
        }
        else
        {
            root = recursiveInsert(a,root);
        }
    }
    
    private BTreeNode recursiveInsert(StringDataItem a, BTreeNode current)
    {
        
        if(current == null)
        {
            current = new BTreeNode(a);
        }
        else
        {
            if(a.isLess(current.getData()))
            {
                current.lst = recursiveInsert(a, current.lst);
            }
            else
            {
                current.rst = recursiveInsert(a, current.rst);
            }
        }
        
        return current;
    }
    
    BTreeNode search(StringDataItem a)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return recursiveSearch(a,root);
        }
    }
    
    BTreeNode recursiveSearch(StringDataItem a, BTreeNode current)
    {
        if(current == null)
        {
            return null;
        }
        else if(current.isEqual(a))
        {
            return current;
        }
        
        else
        {
            if(a.isLess(current.getData()))
            {
                return recursiveSearch(a, current.lst);
            }
            
            else
                return recursiveSearch(a, current.rst);
        }
    }
    
    boolean delete(StringDataItem a)
    {
        if(root == null)
        {
            return false;
        }
        else
        {
            return recursiveDelete(a,root);
        }
    }
    
    boolean recursiveDelete(StringDataItem a, BTreeNode current)
    {
        
        if(current == null)
        {
            return false;
        }
        else if(current.lst != null && current.lst.isEqual(a)){
        
            if(current.lst.lst == null && current.lst.rst == null)
            {
                current.lst = null;
            }
            else if(current.lst.lst == null || current.lst.rst == null)
            {
                if(current.lst.lst != null)
                {
                    current.lst = current.lst.lst;
                }
                else
                {
                    current.lst = current.lst.rst;
                }
            }
            else
            {
                BTreeNode right=current.lst.rst;
                BTreeNode left=current.lst.lst;
                current.lst = null;
                insert(left.getData());
                insert(right.getData());
            }
            return true;
        
        
        }
        else if(current.rst != null && current.rst.isEqual(a)){
        
            if(current.rst.lst == null && current.rst.rst == null)
            {
                current.rst = null;
            }
            else if(current.rst.lst == null || current.rst.rst == null)
            {
                if(current.rst.lst != null)
                {
                    current.rst = current.rst.lst;
                }
                else
                {
                    current.rst = current.rst.rst;
                }
            }
            else
            {
                BTreeNode right=current.rst.rst;
                BTreeNode left=current.rst.lst;
                current.rst = null;
                insert(left.getData());
                insert(right.getData());
                
            }
            return true;
        
        
        }
        
            if(a.isLess(current.getData()))
            {
                return recursiveDelete(a, current.lst);
            }
            else
                return recursiveDelete(a, current.rst);
    }
    
    void Traverse()
    {
        if(root == null)
        {
            return;
        }
        else
        {
            InorderTraverse(root);
        }
    }
    
    void TraverseReverse()
    {
        if(root == null)
        {
            return;
        }
        else
        {
            InorderTraverseReverse(root);
        }
    }
    
    void InorderTraverse(BTreeNode current)
    {
        
        
        if(current == null)
            return;
        else
        {
            InorderTraverse(current.lst);
        }
        System.out.println(current.getData().get());
        InorderTraverse(current.rst);
    }
    void InorderTraverseReverse(BTreeNode current)
    {
        
        
        if(current == null)
            return;
        else
        {
            
            InorderTraverseReverse(current.rst);
            
        }
        System.out.println(current.getData().get());
        InorderTraverseReverse(current.lst);
        
        
    }
}
