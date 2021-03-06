package net.storeapp.storeapp.dal.entity;
// Generated May 16, 2020 9:15:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SizeEntity generated by hbm2java
 */
@Entity
@Table(name="size"
    ,catalog="storeapp"
)
public class SizeEntity  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<SellEntity> sells = new HashSet<SellEntity>(0);
     private Set<ReturnEntity> returnses = new HashSet<ReturnEntity>(0);
     private Set<DamageEntity> damages = new HashSet<DamageEntity>(0);
     private Set<BuyEntity> buys = new HashSet<BuyEntity>(0);
     private Set<StoreEntity> stores = new HashSet<StoreEntity>(0);

    public SizeEntity() {
    }

	
    public SizeEntity(String name) {
        this.name = name;
    }
    public SizeEntity(String name, Set<SellEntity> sells, Set<ReturnEntity> returnses, Set<DamageEntity> damages, Set<BuyEntity> buys, Set<StoreEntity> stores) {
       this.name = name;
       this.sells = sells;
       this.returnses = returnses;
       this.damages = damages;
       this.buys = buys;
       this.stores = stores;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=150)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="size")
    public Set<SellEntity> getSells() {
        return this.sells;
    }
    
    public void setSells(Set<SellEntity> sells) {
        this.sells = sells;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="size")
    public Set<ReturnEntity> getReturnses() {
        return this.returnses;
    }
    
    public void setReturnses(Set<ReturnEntity> returnses) {
        this.returnses = returnses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="size")
    public Set<DamageEntity> getDamages() {
        return this.damages;
    }
    
    public void setDamages(Set<DamageEntity> damages) {
        this.damages = damages;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="size")
    public Set<BuyEntity> getBuys() {
        return this.buys;
    }
    
    public void setBuys(Set<BuyEntity> buys) {
        this.buys = buys;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="size")
    public Set<StoreEntity> getStores() {
        return this.stores;
    }
    
    public void setStores(Set<StoreEntity> stores) {
        this.stores = stores;
    }




}


