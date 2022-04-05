package line2.line2_back3.homeRoomTable.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.homeRoomTable.model.HomeRoomTable;
import line2.line2_back3.homeRoomTable.repository.HomeRoomTableRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeRoomTableServiceImpl implements HomeRoomTableService{
    private final HomeRoomTableRepository homeRoomTableRepository;

    @Override
    public HomeRoomTable save(HomeRoomTable homeRoomTable) {
        try {
            log.info("HomeRoomTableService save HomeRoomTable({}) start", homeRoomTable);
            return homeRoomTableRepository.save(homeRoomTable);
        } catch (Exception e) {
            log.error("HomeRoomTableService save HomeRoomTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeRoomTableService save HomeRoomTable end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("HomeRoomTableService delete by id HomeRoomTable(id: {}) start", id);
            homeRoomTableRepository.deleteById(id);
        } catch (Exception e) {
            log.error("HomeRoomTableService delete by id HomeRoomTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeRoomTableService delete by id HomeRoomTable end");
        }
    }

    @Override
    public List<HomeRoomTable> findByHomeId(Long id) {
        try {
            log.info("HomeRoomTableService find by home id HomeRoomTable(id: {}) start", id);
            return homeRoomTableRepository.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeRoomTableService find by home id HomeRoomTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeRoomTableService find by home id HomeRoomTable end");
        }
    }
}
