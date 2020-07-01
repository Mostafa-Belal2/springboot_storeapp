/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.trasformer;

/**
 *
 * @author dell
 */
public interface CommonTransformer<E,B> {
    
    public B fromEntityToBean( E entity);
    public E fromBeanToEntity( B bean);
    
    
}

