package line2.line2_back3.homeFacilityTable.controller;

import java.util.List;

import line2.line2_back3.homeFacilityTable.model.HomeFacilityTable;

public interface HomeFacilityTableController {
    HomeFacilityTable add(HomeFacilityTable homeFacilityTable);

    HomeFacilityTable edit(HomeFacilityTable homeFacilityTable);

    void deleteById(Long id);

    List<HomeFacilityTable> findByHomeId(Long id);
}
