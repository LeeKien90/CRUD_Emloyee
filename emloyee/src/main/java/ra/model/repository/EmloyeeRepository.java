package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Emloyee;

@Repository
public interface EmloyeeRepository extends JpaRepository<Emloyee,Integer> {
    boolean existsByEmail(String email);
}
