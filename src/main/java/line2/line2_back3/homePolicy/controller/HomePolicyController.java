package line2.line2_back3.homePolicy.controller;

import java.util.List;

import line2.line2_back3.homePolicy.model.HomePolicy;

public interface HomePolicyController {
    HomePolicy add(HomePolicy homePolicy);

    HomePolicy edit(HomePolicy homePolicy);

    void delete(Long id);

    List<HomePolicy> getInPolicies();

    List<HomePolicy> getOutPolicies();
}
