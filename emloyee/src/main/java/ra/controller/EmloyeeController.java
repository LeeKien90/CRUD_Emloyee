package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.EmloyeeRequest;
import ra.model.entity.Emloyee;
import ra.model.repository.EmloyeeRepository;
import ra.model.service.EmloyeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmloyeeController {
    @Autowired
    private EmloyeeService emloyeeService;

    @GetMapping("/getAll")
    public List<Emloyee> getAll() {
        return emloyeeService.findAll();
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<?> getEmloyeeById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(emloyeeService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok("Id not found");
        }

    }
    @PostMapping("/create")
    public ResponseEntity<?> createEmloyee(@RequestBody EmloyeeRequest emloyeeRequest) {
        try {
            return ResponseEntity.ok(emloyeeService.save(emloyeeRequest));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.ok("ERROR: Unknown role");
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmloyee(@PathVariable("id") int id, @RequestBody EmloyeeRequest emloyeeRequest) {
        emloyeeRequest.setId(id);
        return ResponseEntity.ok(emloyeeService.update(emloyeeRequest));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmloyee(@PathVariable("id") int id) {
        try {
            emloyeeService.deleteEmloyee(id);
            return "Delete Complete";
        } catch (Exception e) {
            e.printStackTrace();
            return "Id not found";
        }
    }
}
