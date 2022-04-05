package line2.line2_back3.homeRoomTable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.homeRoomTable.model.HomeRoomTable;

import java.util.List;

public interface HomeRoomTableRepository extends JpaRepository<HomeRoomTable, Long> {
    List<HomeRoomTable> findByHomeId(Long id);

    HomeRoomTable findByRoomId(Long id);
}
