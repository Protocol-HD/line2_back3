package line2.line2_back3.homePolicyTable.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homePolicyTable.model.HomePolicyTable;
import line2.line2_back3.homePolicyTable.repository.HomePolicyTableRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomePolicyTableServiceImpl implements HomePolicyTableService{
    private final HomePolicyTableRepository homePolicyTableRepository;

    @Override
    public HomePolicyTable save(HomePolicyTable homePolicyTable) {
        try {
            log.info("HomePolicyTableService save HomePolicyTable({}) start", homePolicyTable);
            return homePolicyTableRepository.save(homePolicyTable);
        } catch (Exception e) {
            log.error("HomePolicyTableService save HomePolicyTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyTableService save HomePolicyTable end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomePolicyTableService delete by id HomePolicyTable(id: {}) start", id);
            homePolicyTableRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomePolicyTableService delete by id HomePolicyTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomePolicyTableService delete by id HomePolicyTable end");
        }

    }

    @Override
    public List<HomePolicyTable> findByHomeId(Long id) {
        try {
            log.info("HomePolicyTableService find by home id HomePolicyTable(id: {}) start", id);
            return homePolicyTableRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomePolicyTableService find by home id HomePolicyTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomePolicyTableService find by home id HomePolicyTable end");
        }
    }
}
