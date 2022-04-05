package line2.line2_back3.homeCategory.controller;

import java.util.List;

import line2.line2_back3.homeCategory.model.HomeCategory;

public interface HomeCategoryController {
    HomeCategory findById(Long id);

    List<HomeCategory> findAll();
}
