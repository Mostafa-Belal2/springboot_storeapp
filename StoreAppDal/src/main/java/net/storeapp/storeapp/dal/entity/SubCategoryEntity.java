package net.storeapp.storeapp.dal.entity;
// Generated May 16, 2020 9:15:37 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SubCategoryEntity generated by hbm2java
 */
@Entity
@Table(name="sub_category"
    ,catalog="storeapp"
)
public class SubCategoryEntity  implements java.io.Serializable {


     private Integer id;
     private CategoryEntity category;
     private String name;

    public SubCategoryEntity() {
    }

    public SubCategoryEntity(CategoryEntity category, String name) {
       this.category = category;
       this.name = name;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    public CategoryEntity getCategory() {
        return this.category;
    }
    
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    
    @Column(name="name", nullable=false, length=150)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


