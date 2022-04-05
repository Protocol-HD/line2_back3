package line2.line2_back3.homeImageTable.controller;

import java.util.List;

import line2.line2_back3.homeImageTable.model.HomeImageTable;

public interface HomeImageTableController {
    HomeImageTable add(HomeImageTable homeImageTable);

    HomeImageTable edit(HomeImageTable homeImageTable);

    void deleteById(Long id);

    List<HomeImageTable> findByHomeId(Long id);
}
