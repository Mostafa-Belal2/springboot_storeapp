package net.storeapp.storeapp.dal.entity;
// Generated May 16, 2020 9:15:37 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserEntity generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="storeapp"
)
public class UserEntity  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String password;
     private String role;

    public UserEntity() {
    }

    public UserEntity(String name, String password, String role) {
       this.name = name;
       this.password = password;
       this.role = role;
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

    
    @Column(name="password", nullable=false, length=150)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="role", nullable=false, length=150)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}

