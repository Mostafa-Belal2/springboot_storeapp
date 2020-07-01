/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.bll.manager;

import java.util.List;
import net.storeapp.storeapp.common.ReturnBean;
import net.storeapp.storeapp.common.DamageBean;

/**
 *
 * @author dell
 */
public interface ReturnManager {
    
    public List<ReturnBean> listReturn();

    public ReturnBean findReturnById(Integer id);

    public ReturnBean addReturn(ReturnBean returnsBean);

    public ReturnBean updateReturn(ReturnBean returnsBean);

    public void removeReturn(Integer id);
    
    public List<DamageBean> listDamage();

    public DamageBean findDamageById(Integer id);

    public DamageBean addDamage(DamageBean damageBean);

    public DamageBean updateDamage(DamageBean damageBean);

    public void removeDamage(Integer id);
}
