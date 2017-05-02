/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public abstract class GenericItemType {
    
    abstract boolean isLess(GenericItemType a);
    
    abstract boolean isGreater(GenericItemType a);
    
    abstract boolean isEqual(GenericItemType a);

}
