package line2.line2_back3.homePolicyTable.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.homePolicyTable.model.HomePolicyTable;
import line2.line2_back3.homePolicyTable.service.HomePolicyTableService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomePolicyTableControllerImpl implements HomePolicyTableController{
    private final HomePolicyTableService homePolicyTableService;

    @Override
    @PostMapping("/v1/home_policy_table")
    public HomePolicyTable add(@RequestBody HomePolicyTable homePolicyTable) {
        try {
            log.info("HomePolicyTableController add HomePolicyTable({}) start", homePolicyTable);
            return homePolicyTableService.save(homePolicyTable);
        } catch (Exception e) {
            log.error("HomePolicyTableController add HomePolicyTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyTableController add HomePolicyTable end");
        }
    }

    @Override
    @PutMapping("/v1/home_policy_table")
    public HomePolicyTable edit(HomePolicyTable homePolicyTable) {
        try {
            log.info("HomePolicyTableController edit HomePolicyTable({}) start", homePolicyTable);
            return homePolicyTableService.save(homePolicyTable);
        } catch (Exception e) {
            log.error("HomePolicyTableController edit HomePolicyTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyTableController edit HomePolicyTable end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_policy_table/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("HomePolicyTableController delete by id HomePolicyTable(id: {}) start", id);
            homePolicyTableService.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyTableController delete by id HomePolicyTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyTableController delete by id HomePolicyTable end");
        }
    }

    @Override
    @GetMapping("/v1/home_policy_table/home/{id}")
    public List<HomePolicyTable> findByHomeId(@PathVariable Long id) {
        try {
            log.info("HomePolicyTableController find by id HomePolicyTable(id: {}) start", id);
            return homePolicyTableService.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomePolicyTableController find by id HomePolicyTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyTableController find by id HomePolicyTable end");
        }
    }
}
