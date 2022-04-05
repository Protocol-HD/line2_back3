package line2.line2_back3.homeFacility.controller;

import java.util.List;

import line2.line2_back3.homeFacility.model.HomeFacility;

public interface HomeFacilityController {
    HomeFacility findById(Long id);

    List<HomeFacility> findAll();
}
