package line2.line2_back3.homeFacilityTable.service;

import java.util.List;

import line2.line2_back3.homeFacilityTable.model.HomeFacilityTable;

public interface HomeFacilityTableService {
    HomeFacilityTable save(HomeFacilityTable homeFacilityTable);

    void deleteById(Long id);

    List<HomeFacilityTable> findByHomeId(Long id);
}
