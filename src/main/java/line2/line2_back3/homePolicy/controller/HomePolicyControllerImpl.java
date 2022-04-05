package line2.line2_back3.homePolicy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.homePolicy.model.HomePolicy;
import line2.line2_back3.homePolicy.service.HomePolicyService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomePolicyControllerImpl implements HomePolicyController{
    private final HomePolicyService homePolicyService;

    @Override
    @PostMapping("/v1/home_policy")
    public HomePolicy add(@RequestBody HomePolicy homePolicy) {
        try {
            log.info("HomePolicyController add HomePolicy({}) start", homePolicy);
            return homePolicyService.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyController add HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController add HomePolicy end");
        }
    }

    @Override
    @PutMapping("/v1/home_policy")
    public HomePolicy edit(@RequestBody HomePolicy homePolicy) {
        try {
            log.info("HomePolicyController edit HomePolicy({}) start", homePolicy);
            return homePolicyService.save(homePolicy);
        } catch (Exception e) {
            log.error("HomePolicyController edit HomePolicy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController edit HomePolicy end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_policy/{id}")
    public void delete(@PathVariable Long id) {
        try {
            log.info("HomePolicyController delete by id HomePolicy({}) start", id);
            homePolicyService.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyController delete by id HomePolicy failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyController delete by id HomePolicy end");
        }
    }

    @Override
    @GetMapping("/v1/home_policy/check_in")
    public List<HomePolicy> getInPolicies() {
        try {
            log.info("HomePolicyController find check in policy start");
            return homePolicyService.getInPolicies();
        } catch (Exception e) {
            log.error("HomePolicyController find check in policy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController find check in policy end");
        }
    }

    @Override
    @GetMapping("/v1/home_policy/check_out")
    public List<HomePolicy> getOutPolicies() {
        try {
            log.info("HomePolicyController find check out policy start");
            return homePolicyService.getOutPolicies();
        } catch (Exception e) {
            log.error("HomePolicyController find check out policy failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyController find check out policy end");
        }
    }
}
