package line2.line2_back3.checkTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.checkTime.model.CheckTime;

public interface CheckTimeRepository extends JpaRepository<CheckTime, Long> {
    
}
