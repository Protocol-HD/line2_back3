package line2.line2_back3.homeImageTable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.homeImageTable.model.HomeImageTable;

import java.util.List;

public interface HomeImageTableRepository extends JpaRepository<HomeImageTable, Long> {
    List<HomeImageTable> findAllByHomeId(Long id);

    HomeImageTable findFirstByHomeId(Long id);
}
