package line2.line2_back3.homeCategory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.homeCategory.model.HomeCategory;
import line2.line2_back3.homeCategory.service.HomeCategoryService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomeCategoryControllerImpl implements HomeCategoryController{
    private final HomeCategoryService homeCategoryService;

    @Override
    @GetMapping("/v1/home_category/{id}")
    public HomeCategory findById(@PathVariable Long id) {
        try {
            log.info("HomeCategoryController find by id HomeCategory(id: {}) start", id);
            return homeCategoryService.findById(id);
        } catch (Exception e) {
            log.error("HomeCategoryController find by id HomeCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryController find by id HomeCategory end");
        }
    }

    @Override
    @GetMapping("/v1/home_category/list")
    public List<HomeCategory> findAll() {
        try {
            log.info("HomeCategoryController find all HomeCategories start");
            return homeCategoryService.findAll();
        } catch (Exception e) {
            log.error("HomeCategoryController find all HomeCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryController find all HomeCategories end");
        }
    }
}
