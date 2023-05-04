package ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private int roleId;
    @Column(name = "roleName")
    @Enumerated(EnumType.STRING)
    private ERoles roleName;

    public Roles() {
    }

    public Roles(int roleId, ERoles roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public ERoles getRoleName() {
        return roleName;
    }

    public void setRoleName(ERoles roleName) {
        this.roleName = roleName;
    }
}
