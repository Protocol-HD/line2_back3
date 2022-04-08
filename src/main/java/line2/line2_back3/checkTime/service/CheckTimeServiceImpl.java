package line2.line2_back3.checkTime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import line2.line2_back3.checkTime.repository.CheckTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CheckTimeServiceImpl implements CheckTimeService {
    private final CheckTimeRepository checkTimeRepository;

    @Override
    public List<String> findAll() {
        try {
            log.info("CheckTimeService find all CheckTimes start");
            List<String> checkTimes = new ArrayList<>();
            checkTimeRepository.findAll().forEach(checkTime -> {
                checkTimes.add(checkTime.getCheckTime());
            });
            return checkTimes;
        } catch (Exception e) {
            log.error("CheckTimeService find all CheckTimes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("CheckTimeService find all CheckTimes end");
        }
    }
}
