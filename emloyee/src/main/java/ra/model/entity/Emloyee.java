package ra.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Emloyee")
public class Emloyee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "nameEmloyee")
    private String nameEmloyee;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "department")
    private String department;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Emloyee_Role", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Roles> listRoles = new HashSet<>();

    public Emloyee() {
    }

    public Emloyee(int id, String nameEmloyee, String email, String department, Set<Roles> listRoles) {
        this.id = id;
        this.nameEmloyee = nameEmloyee;
        this.email = email;
        this.department = department;
        this.listRoles = listRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmloyee() {
        return nameEmloyee;
    }

    public void setNameEmloyee(String nameEmloyee) {
        this.nameEmloyee = nameEmloyee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Roles> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<Roles> listRoles) {
        this.listRoles = listRoles;
    }
}
