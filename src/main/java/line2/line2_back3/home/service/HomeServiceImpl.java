package line2.line2_back3.home.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.checkTime.repository.CheckTimeRepository;
import line2.line2_back3.home.model.Home;
import line2.line2_back3.home.model.HomeDto;
import line2.line2_back3.home.model.HomeListDto;
import line2.line2_back3.home.model.HomeStatusDto;
import line2.line2_back3.home.repository.HomeRepository;
import line2.line2_back3.homeCategory.repository.HomeCategoryRepository;
import line2.line2_back3.homeFacility.repository.HomeFacilityRepository;
import line2.line2_back3.homeFacilityTable.model.HomeFacilityTable;
import line2.line2_back3.homeFacilityTable.repository.HomeFacilityTableRepository;
import line2.line2_back3.homeImageTable.model.HomeImageTable;
import line2.line2_back3.homeImageTable.repository.HomeImageTableRepository;
import line2.line2_back3.homePolicy.model.HomePolicy;
import line2.line2_back3.homePolicy.repository.HomePolicyRepository;
import line2.line2_back3.homePolicyTable.model.HomePolicyTable;
import line2.line2_back3.homePolicyTable.repository.HomePolicyTableRepository;
import line2.line2_back3.homeRoomTable.model.HomeRoomTable;
import line2.line2_back3.homeRoomTable.repository.HomeRoomTableRepository;
import line2.line2_back3.image.model.Image;
import line2.line2_back3.image.repository.ImageRepository;
import line2.line2_back3.restApi.RestApiService;
import line2.line2_back3.room.model.Room;
import line2.line2_back3.room.repository.RoomRepository;
import line2.line2_back3.systemMessage.SystemMessage;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final HomeRepository homeRepository;
    private final HomeCategoryRepository homeCategoryRepository;
    private final ImageRepository imageRepository;
    private final HomeImageTableRepository homeImageTableRepository;
    private final HomePolicyRepository homePolicyRepository;
    private final HomePolicyTableRepository homePolicyTableRepository;
    private final HomeFacilityRepository homeFacilityRepository;
    private final HomeFacilityTableRepository homeFacilityTableRepository;
    private final RoomRepository roomRepository;
    private final HomeRoomTableRepository homeRoomTableRepository;
    private final RestApiService restApiService;
    private final CheckTimeRepository checkTimeRepository;

    public void HomeImageAdd(List<String> images, Home home) {
        images.forEach(image -> {
            homeImageTableRepository.save(
                    HomeImageTable.builder()
                            .home(home)
                            .image(imageRepository.save(Image.builder().imageName(image).build()))
                            .build());
        });
    }

    public void HomePolicyAdd(List<Long> homePolicies, String homePolicyCustom, Home home) {
        homePolicies.forEach(homePolicy -> {
            homePolicyTableRepository.save(
                    HomePolicyTable.builder()
                            .home(home)
                            .homePolicy(homePolicyRepository.findById(homePolicy).get())
                            .build());
        });
        homePolicyTableRepository.save( 
                HomePolicyTable.builder()
                        .home(home)
                        .homePolicy(homePolicyRepository.save(
                                HomePolicy.builder()
                                        .homePolicy(homePolicyCustom)
                                        .policyType(3)
                                        .build()))
                        .build());
    }

    public void HomeFacilityAdd(List<Long> homeFacilities, Home home) {
        homeFacilities.forEach(homeFacility -> {
            homeFacilityTableRepository.save(
                    HomeFacilityTable.builder()
                            .home(home)
                            .homeFacility(homeFacilityRepository.findById(homeFacility).get())
                            .build());
        });
    }

    public void HomeRoomAdd(HomeDto homeDto, Home home) {
        List<Long> newRooms = new ArrayList<>();

        homeDto.getRooms().forEach(room -> {
            if (room.getId() != null) {
                roomRepository.save(room);
                newRooms.add(room.getId());
            } else {
                Room newRoom = roomRepository.save(room);
                homeRoomTableRepository.save(HomeRoomTable.builder()
                        .home(homeRepository.findById(home.getId()).get())
                        .room(newRoom)
                        .build());
                newRooms.add(newRoom.getId());
            }
        });

        homeRoomTableRepository.findByHomeId(homeDto.getHomeId()).forEach(homeRoom -> {
            if (!newRooms.contains(homeRoom.getRoom().getId())) {
                restApiService.deleteAllReservation(restApiService.getByRoomId(homeRoom.getRoom().getId()));
                homeRoomTableRepository.delete(homeRoomTableRepository.findByRoomId(homeRoom.getRoom().getId()));
                roomRepository.deleteById(homeRoom.getRoom().getId());
            }
        });
    }

    @Override
    public SystemMessage add(HomeDto homeDto) {
        try {
            log.info("HomeService save Home({}) start", homeDto);
            log.info("1. save home");
            Home home = homeRepository.save(Home.builder()
                    .id(homeDto.getHomeId())
                    .homeName(homeDto.getHomeName())
                    .homeAddress(homeDto.getHomeAddress())
                    .coordinateX(homeDto.getCoordinateX())
                    .coordinateY(homeDto.getCoordinateY())
                    .homeCategory(homeCategoryRepository.findById(homeDto.getHomeCategoryId()).get())
                    .homeInformation(homeDto.getHomeInformation())
                    .user(restApiService.getUserById(homeDto.getUserId()))
                    .homeZipCode(homeDto.getHomeZipCode())
                    .status(true)
                    .checkInTime(checkTimeRepository.findById(homeDto.getCheckInTimeId()).get())
                    .checkOutTime(checkTimeRepository.findById(homeDto.getCheckOutTimeId()).get())
                    .build());

            log.info("2. save home images");
            HomeImageAdd(homeDto.getImages(), home);
            log.info("3. save home policies");
            HomePolicyAdd(homeDto.getHomePolicies(), homeDto.getHomePolicyCustom(), home);
            log.info("4. save home facilities");
            HomeFacilityAdd(homeDto.getHomeFacilities(), home);
            log.info("5. save/edit home rooms");
            HomeRoomAdd(homeDto, home);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 등록 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService save Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 등록 실패")
                    .build();
        } finally {
            log.info("HomeService save Home end");
        }
    }

    @Override
    public SystemMessage edit(HomeDto homeDto) {
        try {
            log.info("HomeService edit Home({}) start", homeDto);
            log.info("1. delete home images");
            HomeImageDelete(homeDto.getHomeId());
            log.info("2. delete home policies");
            HomePolicyDelete(homeDto.getHomeId());
            log.info("3. delete home facilities");
            HomeFacilityDelete(homeDto.getHomeId());
            add(homeDto);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 정보 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService save Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 정보 변경 실패")
                    .build();
        } finally {
            log.info("HomeService save Home end");
        }
    }

    @Override
    public HomeDto findById(Long id) {
        try {
            log.info("HomeService find by id Home(id: {}) start", id);
            log.info("1. find home");
            Home home = homeRepository.findById(id).get();
            List<String> images = new ArrayList<>();
            List<Long> homePolicies = new ArrayList<>();
            List<Long> homeFacilities = new ArrayList<>();
            List<Room> rooms = new ArrayList<>();

            log.info("2. find all home image");
            homeImageTableRepository.findAllByHomeId(id).forEach(homeImageTable -> {
                images.add(homeImageTable.getImage().getImageName());
            });
            log.info("3. find all home policies");
            homePolicyTableRepository.findByHomeId(id).forEach(homePolicyTable -> {
                homePolicies.add(homePolicyTable.getHomePolicy().getId());
            });
            log.info("4. find all home facilities");
            homeFacilityTableRepository.findByHomeId(id).forEach(homeFacilityTable -> {
                homeFacilities.add(homeFacilityTable.getHomeFacility().getId());
            });
            log.info("5. find all home rooms");
            homeRoomTableRepository.findByHomeId(id).forEach(homeRoomTable -> {
                rooms.add(homeRoomTable.getRoom());
            });

            log.info("6. prepare done");
            return HomeDto.builder()
                    .homeId(id)
                    .homeName(home.getHomeName())
                    .homeAddress(home.getHomeAddress())
                    .coordinateX(home.getCoordinateX())
                    .coordinateY(home.getCoordinateY())
                    .homeCategoryId(home.getHomeCategory().getId())
                    .homeInformation(home.getHomeInformation())
                    .userId(home.getUser().getId())
                    .homeZipCode(home.getHomeZipCode())
                    .images(images)
                    .homePolicies(homePolicies.subList(0, homePolicies.size() - 1))
                    .homePolicyCustom(homePolicyRepository.findById(homePolicies.get(homePolicies.size() - 1)).get()
                            .getHomePolicy())
                    .homeFacilities(homeFacilities)
                    .rooms(rooms)
                    .status(home.isStatus())
                    .checkInTimeId(home.getCheckInTime().getId())
                    .checkOutTimeId(home.getCheckOutTime().getId())
                    .build();
        } catch (Exception e) {
            log.error("HomeService find by id Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find by id Home end");
        }
    }

    @Override
    public Home findByIdNotDto(Long id) {
        try {
            log.info("HomeService find by id not dto Home start");
            return homeRepository.findById(id).get();
        } catch (Exception e) {
            log.error("HomeService find by id not dto Home failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find by id not dto Home end");
        }
    }

    @Override
    public List<HomeListDto> findAll() {
        try {
            log.info("HomeService find all Homes start");
            return homeListToHomeListDto(homeRepository.findAll());
        } catch (Exception e) {
            log.error("HomeService find all Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find all Homes end");
        }
    }

    public void HomeImageDelete(Long id) {
        homeImageTableRepository.findAllByHomeId(id).forEach(homeImage -> {
            homeImageTableRepository.delete(homeImage);
            imageRepository.deleteById(homeImage.getImage().getId());
        });
    }

    public void HomePolicyDelete(Long id) {
        homePolicyTableRepository.deleteAll(homePolicyTableRepository.findByHomeId(id));
    }

    public void HomeFacilityDelete(Long id) {
        homeFacilityTableRepository.deleteAll(homeFacilityTableRepository.findByHomeId(id));
    }

    public void HomeRoomDelete(Long id) {
        homeRoomTableRepository.findByHomeId(id).forEach(homeRoom -> {
            homeRoomTableRepository.delete(homeRoom);
            roomRepository.deleteById(homeRoom.getRoom().getId());
        });
    }

    @Override
    public SystemMessage deleteById(Long id) {
        try {
            log.info("HomeService delete by id Home(id: {}) start", id);
            log.info("1. delete home images");
            HomeImageDelete(id);
            log.info("2. delete home policies");
            HomePolicyDelete(id);
            log.info("3. delete home facilities");
            HomeFacilityDelete(id);
            log.info("4. delete reservation rooms");
            restApiService.deleteAllReservation(restApiService.getByHomeId(id));
            log.info("5. delete home rooms");
            HomeRoomDelete(id);
            log.info("6. delete home");
            homeRepository.deleteById(id);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 삭제 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService delete by id Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 삭제 실패")
                    .build();
        } finally {
            log.info("HomeService delete by id Home end");
        }
    }

    @Override
    public List<HomeListDto> findByHomeAddress(String homeAddress) {
        try {
            log.info("HomeService find by home address Homes(homeAddress: {}) start", homeAddress);
            return homeListToHomeListDto(homeRepository.findByHomeAddressContainingAndStatus(homeAddress, true));
        } catch (Exception e) {
            log.error("HomeService find by home address Homes failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("HomeService find by home address Homes end");
        }
    }

    public List<HomeListDto> homeListToHomeListDto(List<Home> homes) {
        List<HomeListDto> homeListDtos = new ArrayList<>();
        log.info("prepare find all home facilities");
        homes.forEach(home -> {
            List<Long> homeFacilities = new ArrayList<>();
            log.info("find home facilities id: {}", home.getId());
            homeFacilityTableRepository.findByHomeId(home.getId()).forEach(homeFacilityTable -> {
                homeFacilities.add(homeFacilityTable.getHomeFacility().getId());
            });
            homeListDtos.add(HomeListDto.builder()
                    .homeId(home.getId())
                    .homeName(home.getHomeName())
                    .homeAddress(home.getHomeAddress())
                    .coordinateX(home.getCoordinateX())
                    .coordinateY(home.getCoordinateY())
                    .homeCategoryId(home.getHomeCategory().getId())
                    .image(homeImageTableRepository.findAllByHomeId(home.getId()).get(0).getImage().getImageName())
                    .homeFacilities(homeFacilities)
                    .build());
        });
        return homeListDtos;
    }

    @Override
    public SystemMessage changeStatus(HomeStatusDto homeStatusDto) {
        try {
            log.info("HomeService change status Home({}) start", homeStatusDto);
            Home home = homeRepository.findById(homeStatusDto.getHomeId()).get();
            home.setStatus(homeStatusDto.isStatus());
            homeRepository.save(home);
            return SystemMessage.builder()
                    .code(1)
                    .message("숙소 상태 변경 성공")
                    .build();
        } catch (Exception e) {
            log.error("HomeService change status Home failure, error: {}", e.getMessage());
            return SystemMessage.builder()
                    .code(2)
                    .message("숙소 상태 변경 실패")
                    .build();
        } finally {
            log.info("HomeService change status Home end");
        }
    }
}
