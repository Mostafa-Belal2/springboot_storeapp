package net.storeapp.storeapp.dal;

import java.util.List;
import net.storeapp.storeapp.dal.entity.CategoryEntity;
import net.storeapp.storeapp.dal.entity.SupplierEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context.xml");
        SupplierManager manager = appCon.getBean("supplierManager", SupplierManager.class);
        List<SupplierEntity> cityList = manager.findSupplierList(appCon);
        for (SupplierEntity city : cityList) {
            System.out.println(city.getName());
        }
//        CategoryEntity categoryEntity = new CategoryEntity("asdcxz");
//        categoryEntity = manager.addCategory(appCon, categoryEntity);
//        System.out.println(categoryEntity);
    }

}
//
