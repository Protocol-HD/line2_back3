package line2.line2_back3.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.home.model.Home;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Long> {
    List<Home> findByHomeAddressContainingAndStatus(String homeAddress, boolean status);

    List<Home> findByStatus(boolean status);

    Home findByUserId(Long id);
}
