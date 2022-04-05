package line2.line2_back3.homeImageTable.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homeImageTable.model.HomeImageTable;
import line2.line2_back3.homeImageTable.repository.HomeImageTableRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeImageTableServiceImpl implements HomeImageTableService {
    private final HomeImageTableRepository homeImageTableRepository;

    @Override
    public HomeImageTable save(HomeImageTable homeImageTable) {
        try {
            log.info("HomeImageTableService save HomeImageTable({}) start", homeImageTable);
            return homeImageTableRepository.save(homeImageTable);
        } catch (Exception e) {
            log.error("HomeImageTableService save HomeImageTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableService save HomeImageTable end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomeImageTableService delete by id HomeImageTable(id: {}) start", id);
            homeImageTableRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomeImageTableService delete by id HomeImageTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeImageTableService delete by id HomeImageTable end");
        }
    }

    @Override
    public List<HomeImageTable> findByHomeId(Long id) {
        try {
            log.info("HomeImageTableService find by home id HomeImageTable({}) start", id);
            return homeImageTableRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeImageTableService find by home id HomeImageTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeImageTableService find by home id HomeImageTable end");
        }
    }
}
