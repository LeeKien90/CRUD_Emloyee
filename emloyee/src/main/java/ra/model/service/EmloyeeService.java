package ra.model.service;

import ra.model.dto.EmloyeeRequest;
import ra.model.entity.Emloyee;

import java.util.List;

public interface EmloyeeService {
    List<Emloyee> findAll();
    Emloyee findById(int id);
    String save(EmloyeeRequest emloyeeRequest);
    String update(EmloyeeRequest emloyeeRequest);
    void deleteEmloyee(int id);
}
