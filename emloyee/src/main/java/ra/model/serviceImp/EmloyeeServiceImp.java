package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dto.EmloyeeRequest;
import ra.model.entity.ERoles;
import ra.model.entity.Emloyee;
import ra.model.entity.Roles;
import ra.model.repository.EmloyeeRepository;
import ra.model.repository.RolesRepository;
import ra.model.service.EmloyeeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmloyeeServiceImp implements EmloyeeService {
    @Autowired
    private EmloyeeRepository emloyeeRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public List<Emloyee> findAll() {
        return emloyeeRepository.findAll();
    }

    @Override
    public Emloyee findById(int id) {
        return emloyeeRepository.findById(id).get();
    }

    @Override
    public String save(EmloyeeRequest emloyeeRequest) {
        boolean check = emloyeeRepository.existsByEmail(emloyeeRequest.getEmail());
        if (check) {
            return "Email already exists";
        }
        Emloyee emloyee = new Emloyee();
        emloyee.setNameEmloyee(emloyeeRequest.getNameEmloyee());
        emloyee.setEmail(emloyeeRequest.getEmail());
        emloyee.setDepartment(emloyeeRequest.getDepartment());
        Set<String> strRoles = emloyeeRequest.getListRoles();
        Set<Roles> listRoles = new HashSet<>();
        if (strRoles == null) {
            Roles emloyeeRole = rolesRepository.findByRoleName(ERoles.ROLES_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            listRoles.add(emloyeeRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Roles adminRole =rolesRepository.findByRoleName(ERoles.ROLES_ADMIN).orElseThrow(() -> new RuntimeException("Error: Admin"));
                        listRoles.add(adminRole);
                        break;
                    case "user":
                        Roles userRole =rolesRepository.findByRoleName(ERoles.ROLES_USER).orElseThrow(() -> new RuntimeException("Error: User"));
                        listRoles.add(userRole);
                        break;
                    default:
                       throw new IllegalArgumentException("ERROR: Unknown role");
                }
            });
        }
        emloyee.setListRoles(listRoles);
        try {
            emloyeeRepository.save(emloyee);
            return "Create Complete";
        } catch (Exception e) {
            e.printStackTrace();
            return "Create not complete";
        }

    }

    @Override
    public String update(EmloyeeRequest emloyeeRequest) {
        Emloyee emloyee = emloyeeRepository.findById(emloyeeRequest.getId()).get();
        emloyee.setNameEmloyee(emloyeeRequest.getNameEmloyee());
        emloyee.setEmail(emloyeeRequest.getEmail());
        emloyee.setDepartment(emloyeeRequest.getDepartment());
        try {
            emloyeeRepository.save(emloyee);
            return "Update Complete";
        } catch (Exception e) {
            e.printStackTrace();
            return "Update not complete";
        }

    }


    @Override
    public void deleteEmloyee(int id) {
        emloyeeRepository.deleteById(id);
    }


}
