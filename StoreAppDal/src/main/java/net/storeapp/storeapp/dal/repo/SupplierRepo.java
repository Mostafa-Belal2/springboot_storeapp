/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.dal.repo;

import net.storeapp.storeapp.dal.entity.SupplierEntity;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SupplierRepo extends AbstractRepo<SupplierEntity> {

    public SupplierRepo() {
        super(SupplierEntity.class);
    }

}
