package line2.line2_back3.homePolicy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.homePolicy.model.HomePolicy;

import java.util.List;

public interface HomePolicyRepository extends JpaRepository<HomePolicy, Long> {
    List<HomePolicy> findByPolicyType(int type);
}
