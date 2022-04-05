package line2.line2_back3.homePolicy.service;

import java.util.List;

import line2.line2_back3.homePolicy.model.HomePolicy;

public interface HomePolicyService {
    HomePolicy save(HomePolicy homePolicy);

    void deleteById(Long id);

    List<HomePolicy> getInPolicies();

    List<HomePolicy> getOutPolicies();
}
