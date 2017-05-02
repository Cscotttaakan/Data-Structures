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
public class TokenDataItem extends GenericItemType {
    public String Token;
    
    dataType.state type;
    TokenDataItem()
    {
    }
    
    TokenDataItem(String a)
    {
        Token = a;
    }
    
    TokenDataItem(String a, dataType.state b)
    {
        Token = a;
        type = b;
    }
    
    public String getToken()
    {
        return Token;
    }
    
    public void setToken(String s)
    {
        Token = s;
    }
    
    @Override
    boolean isLess(GenericItemType a)
    {
        return false;
    }
    
    @Override
    boolean isGreater(GenericItemType a)
    {
        return false;
    }
    
    @Override
    boolean isEqual(GenericItemType a)
    {
        return false;
    }
    
    @Override
    public String toString()
    {
        return Token;
    }
    
    
}
