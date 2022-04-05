package line2.line2_back3.homeRoomTable.service;

import java.util.List;

import line2.line2_back3.homeRoomTable.model.HomeRoomTable;

public interface HomeRoomTableService {
    HomeRoomTable save(HomeRoomTable homeRoomTable);

    void deleteById(Long id);

    List<HomeRoomTable> findByHomeId(Long id);
}
