package ra.model.dto;

import java.util.Set;

public class EmloyeeRequest {
    private int id;
    private String nameEmloyee;
    private String email;
    private String department;
    private Set<String> listRoles;

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

    public Set<String> getListRoles() {
        return listRoles;
    }

    public void setListRoles(Set<String> listRoles) {
        this.listRoles = listRoles;
    }
}
