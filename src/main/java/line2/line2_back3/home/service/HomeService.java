package line2.line2_back3.home.service;

import java.util.List;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.home.model.HomeDto;
import line2.line2_back3.home.model.HomeListDto;
import line2.line2_back3.systemMessage.SystemMessage;

public interface HomeService {
    SystemMessage add(HomeDto homeDto);

    SystemMessage edit(HomeDto homeDto);

    HomeDto findById(Long id);

    Home findByIdNotDto(Long id);

    List<HomeListDto> findAll();

    SystemMessage deleteById(Long id);

    List<HomeListDto> findByHomeAddress(String homeAddress);
}
