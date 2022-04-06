package line2.line2_back3.homeImageTable.service;

import java.util.List;

import line2.line2_back3.homeImageTable.model.HomeImageTable;

public interface HomeImageTableService {
    HomeImageTable save(HomeImageTable homeImageTable);

    void deleteById(Long id);

    List<HomeImageTable> findAllByHomeId(Long id);

    String findByHomeId(Long id);
}
