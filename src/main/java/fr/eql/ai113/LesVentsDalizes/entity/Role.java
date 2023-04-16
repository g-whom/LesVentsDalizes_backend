package fr.eql.ai113.LesVentsDalizes.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    /// CONSTRUCTORS ///

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    /// GETTERS ///

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /// SETTER ///

    public void setId(Long id) {
        this.id = id;
    }

    /// @OVERIDE ///
    @Override
    public String getAuthority() {
       // return null;
        return name;
    }

    /// TOSTRING ///

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
