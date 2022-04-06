package line2.line2_back3.homeImageTable.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.homeImageTable.model.HomeImageTable;
import line2.line2_back3.homeImageTable.service.HomeImageTableService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomeImageTableControllerImpl implements HomeImageTableController{
    private final HomeImageTableService homeImageTableService;

    @Override
    @PostMapping("/v1/home_image_table")
    public HomeImageTable add(@RequestBody HomeImageTable homeImageTable) {
        try {
            log.info("HomeImageTableController add HomeImageTable({}) start", homeImageTable);
            return homeImageTableService.save(homeImageTable);
        } catch (Exception e) {
            log.error("HomeImageTableController add HomeImageTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableController add HomeImageTable end");
        }
    }

    @Override
    @PutMapping("/v1/home_image_table")
    public HomeImageTable edit(@RequestBody HomeImageTable homeImageTable) {
        try {
            log.info("HomeImageTableController edit HomeImageTable({}) start", homeImageTable);
            return homeImageTableService.save(homeImageTable);
        } catch (Exception e) {
            log.error("HomeImageTableController edit HomeImageTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableController edit HomeImageTable end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_image_table/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("HomeImageTableController delete by id HomeImageTable(id: {}) start", id);
            homeImageTableService.deleteById(id);
        } catch (Exception e) {
            log.error("HomeImageTableController delete by id HomeImageTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeImageTableController delete by id HomeImageTable end");
        }
    }

    @Override
    @GetMapping("/v1/home_image_table/home/{id}")
    public List<HomeImageTable> findAllByHomeId(@PathVariable Long id) {
        try {
            log.info("HomeImageTableController find by home id HomeImageTable(id: {}) start", id);
            return homeImageTableService.findAllByHomeId(id);
        } catch (Exception e) {
            log.error("HomeImageTableController find by home id HomeImageTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableController find by home id HomeImageTable end");
        }
    }

    @Override
    @GetMapping("/v1/home_image_table/home/one/{id}")
    public String findByHomeId(@PathVariable Long id) {
        try {
            log.info("HomeImageTableController find by home id one image({}) start", id);
            return homeImageTableService.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeImageTableController find by home id one image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableController find by home id one image end");
        }
    }
}
