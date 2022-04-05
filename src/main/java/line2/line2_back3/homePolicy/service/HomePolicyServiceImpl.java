package line2.line2_back3.homePolicy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homePolicy.model.HomePolicy;
import line2.line2_back3.homePolicy.repository.HomePolicyRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomePolicyServiceImpl implements HomePolicyService{
    private final HomePolicyRepository homePolicyRepository;

    @Override
    public HomePolicy save(HomePolicy homePolicy) {
        try {
            log.info("HomePolicyService save HomePolicy({}) start", homePolicy);
            return homePolicyRepository.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyService save HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyService save HomePolicy end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomePolicyService delete by id HomePolicy(id: {}) start", id);
            homePolicyRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyService delete by id HomePolicy failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyService delete by id HomePolicy end");
        }
    }

    @Override
    public List<HomePolicy> getInPolicies() {
        try {
            log.info("HomePolicyService find by policy type 1(check in policy) start");
            return homePolicyRepository.findByPolicyType(1);
        } catch (Exception e) {
            log.error("HomePolicyService find by policy type 1(check in policy) failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyService find by policy type 1(check in policy) end");
        }
    }

    @Override
    public List<HomePolicy> getOutPolicies() {
        try {
            log.info("HomePolicyService find by policy type 2(check out policy) start");
            return homePolicyRepository.findByPolicyType(2);
        } catch (Exception e) {
            log.error("HomePolicyService find by policy type 2(check out policy) failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyService find by policy type 2(check out policy) end");
        }
    }
}
