package line2.line2_back3.homePolicyTable.service;

import java.util.List;

import line2.line2_back3.homePolicyTable.model.HomePolicyTable;

public interface HomePolicyTableService {
    HomePolicyTable save(HomePolicyTable homePolicyTable);

    void deleteById(Long id);

    List<HomePolicyTable> findByHomeId(Long id);
}
