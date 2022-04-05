package line2.line2_back3.homeRoomTable.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.homeRoomTable.model.HomeRoomTable;
import line2.line2_back3.homeRoomTable.service.HomeRoomTableService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class HomeRoomTableControllerImpl implements HomeRoomTableController{
    private final HomeRoomTableService homeRoomTableService;

    @Override
    @PostMapping("/v1/home_room_table")
    public HomeRoomTable add(@RequestBody HomeRoomTable homeRoomTable) {
        try {
            log.info("HomeRoomTableController add HomeRoomTable({}) start", homeRoomTable);
            return homeRoomTableService.save(homeRoomTable);
        } catch (Exception e) {
            log.error("HomeRoomTableController add HomeRoomTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeRoomTableController add HomeRoomTable end");
        }
    }

    @Override
    @PutMapping("/v1/home_room_table")
    public HomeRoomTable edit(@RequestBody HomeRoomTable homeRoomTable) {
        try {
            log.info("HomeRoomTableController edit HomeRoomTable({}) start", homeRoomTable);
            return homeRoomTableService.save(homeRoomTable);
        } catch (Exception e) {
            log.error("HomeRoomTableController edit HomeRoomTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeRoomTableController edit HomeRoomTable end");
        }
    }

    @Override
    @DeleteMapping("/v1/home_room_table/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("HomeRoomTableController delete by id HomeRoomTable(id: {}) start", id);
            homeRoomTableService.deleteById(id);
        } catch (Exception e) {
            log.error("HomeRoomTableController delete by id HomeRoomTable failure, error: {}", e.getMessage());
        } finally {
            log.info("HomeRoomTableController delete by id HomeRoomTable end");
        }
    }

    @Override
    @GetMapping("/v1/home_room_table/home/{id}")
    public List<HomeRoomTable> findByHomeId(@PathVariable Long id) {
        try {
            log.info("HomeRoomTableController find by id HomeRoomTable(id: {}) start", id);
            return homeRoomTableService.findByHomeId(id);
        } catch (Exception e) {
            log.error("HomeRoomTableController find by id HomeRoomTable failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeRoomTableController find by id HomeRoomTable end");
        }
    }
}
