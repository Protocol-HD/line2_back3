package line2.line2_back3.homeFacilityTable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.homeFacilityTable.model.HomeFacilityTable;

import java.util.List;

public interface HomeFacilityTableRepository extends JpaRepository<HomeFacilityTable, Long> {
    List<HomeFacilityTable> findByHomeId(Long id);
}
