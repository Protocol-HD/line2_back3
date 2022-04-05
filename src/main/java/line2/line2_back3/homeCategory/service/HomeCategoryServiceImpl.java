package line2.line2_back3.homeCategory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homeCategory.model.HomeCategory;
import line2.line2_back3.homeCategory.repository.HomeCategoryRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeCategoryServiceImpl implements HomeCategoryService{
    private final HomeCategoryRepository homeCategoryRepository;

    @Override
    public HomeCategory findById(Long id) {
        try {
            log.info("HomeCategoryService find by id HomeCategory(id: {}) start", id);
            return homeCategoryRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeCategoryService find by id HomeCategory failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryService find by id HomeCategory end");
        }
    }

    @Override
    public List<HomeCategory> findAll() {
        try {
            log.info("HomeCategoryService find all HomeCategories start");
            return homeCategoryRepository.findAll();
        } catch (Exception e) {
            log.error("HomeCategoryService find all HomeCategories failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeCategoryService find all HomeCategories end");
        }
    }
}
