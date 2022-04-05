package line2.line2_back3.homeRoomTable.controller;

import java.util.List;

import line2.line2_back3.homeRoomTable.model.HomeRoomTable;

public interface HomeRoomTableController {
    HomeRoomTable add(HomeRoomTable homeRoomTable);

    HomeRoomTable edit(HomeRoomTable homeRoomTable);

    void deleteById(Long id);

    List<HomeRoomTable> findByHomeId(Long id);
}
