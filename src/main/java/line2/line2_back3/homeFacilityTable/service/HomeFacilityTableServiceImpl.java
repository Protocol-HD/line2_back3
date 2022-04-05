package line2.line2_back3.homeFacilityTable.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homeFacilityTable.model.HomeFacilityTable;
import line2.line2_back3.homeFacilityTable.repository.HomeFacilityTableRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeFacilityTableServiceImpl implements HomeFacilityTableService{
    private final HomeFacilityTableRepository homeFacilityTableRepository;

    @Override
    public HomeFacilityTable save(HomeFacilityTable homeFacilityTable) {
        try {
            log.info("HomeFacilityTableService save HomeFacilityTable({}) start", homeFacilityTable);
            return homeFacilityTableRepository.save(homeFacilityTable);
        } catch (Exception e) {
            log.error("HomeFacilityTableService save HomeFacilityTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityTableService save HomeFacilityTable end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomeFacilityTableService delete by id HomeFacilityTable(id: {}) start", id);
            homeFacilityTableRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomeFacilityTableService delete by id HomeFacilityTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeFacilityTableService delete by id HomeFacilityTable end");
        }
    }

    @Override
    public List<HomeFacilityTable> findByHomeId(Long id) {
        try {
            log.info("HomeFacilityTableService find by home id HomeFacilityTable({}) start", id);
            return homeFacilityTableRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeFacilityTableService find by home id HomeFacilityTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeFacilityTableService find by home id HomeFacilityTable end");
        }
    }
}
