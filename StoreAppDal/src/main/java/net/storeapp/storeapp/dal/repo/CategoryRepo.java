/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.storeapp.storeapp.dal.repo;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.storeapp.storeapp.dal.entity.CategoryEntity;
import org.hibernate.query.Query;
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

public class CategoryRepo extends AbstractRepo<CategoryEntity> {

    public CategoryRepo() {
        super(CategoryEntity.class);
    }

    public CategoryEntity findCategoryByName(String name) {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<CategoryEntity> CriteriaQuery = cb.createQuery(CategoryEntity.class);
        Root<CategoryEntity> root = CriteriaQuery.from(CategoryEntity.class);
        CriteriaQuery.select(root);
        CriteriaQuery.where(cb.equal(root.get("name"),name));
        Query<CategoryEntity> query = getCurrentSession().createQuery(CriteriaQuery);
        CategoryEntity list = query.getSingleResult();
        return list;
    }
}
