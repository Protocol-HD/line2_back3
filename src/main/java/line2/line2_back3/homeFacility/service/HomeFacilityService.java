package line2.line2_back3.homeFacility.service;

import java.util.List;

import line2.line2_back3.homeFacility.model.HomeFacility;

public interface HomeFacilityService {
    HomeFacility findById(Long id);

    List<HomeFacility> findAll();
}
