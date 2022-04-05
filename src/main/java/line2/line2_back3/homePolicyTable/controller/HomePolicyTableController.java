package line2.line2_back3.homePolicyTable.controller;

import java.util.List;

import line2.line2_back3.homePolicyTable.model.HomePolicyTable;

public interface HomePolicyTableController {
    HomePolicyTable add(HomePolicyTable homePolicyTable);

    HomePolicyTable edit(HomePolicyTable homePolicyTable);

    void deleteById(Long id);

    List<HomePolicyTable> findByHomeId(Long id);
}
