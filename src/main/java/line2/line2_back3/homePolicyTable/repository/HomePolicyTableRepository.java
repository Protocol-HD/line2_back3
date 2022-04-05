package line2.line2_back3.homePolicyTable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.homePolicyTable.model.HomePolicyTable;

import java.util.List;

public interface HomePolicyTableRepository extends JpaRepository<HomePolicyTable, Long> {
    List<HomePolicyTable> findByHomeId(Long id);
}
