package line2.line2_back3.checkTime.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import line2.line2_back3.checkTime.service.CheckTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class CheckTimeControllerImpl implements CheckTimeController {
    private final CheckTimeService checkTimeService;

    @Override
    @GetMapping("/v1/check_time/list")
    public List<String> findAll() {
        try {
            log.info("CheckTimeController find all CheckTimes start");
            return checkTimeService.findAll();
        } catch (Exception e) {
            log.error("CheckTimeController find all CheckTimes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("CheckTimeController find all CheckTimes end");
        }
    }
}
