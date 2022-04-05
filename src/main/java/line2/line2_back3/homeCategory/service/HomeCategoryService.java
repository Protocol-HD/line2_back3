package line2.line2_back3.homeCategory.service;

import java.util.List;

import line2.line2_back3.homeCategory.model.HomeCategory;

public interface HomeCategoryService {
    HomeCategory findById(Long id);

    List<HomeCategory> findAll();
}
