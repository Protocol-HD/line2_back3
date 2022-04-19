package line2.line2_back3.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import line2.line2_back3.restApi.models.Reservation;
import line2.line2_back3.restApi.models.ReservationHeadCountDto;
import line2.line2_back3.restApi.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestApiService {
    @Value("${user-server-url}")
    String userServer;

    @Value("${reservation-server-url}")
    String reservationServer;

    private final RestTemplate restTemplate;

    public User getUserById(Long id) {
        String url = userServer + "/user/v1/user/" + Long.toString(id);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        log.info("{}", response);
        return response.getBody();
    }

    public void deleteAllReservation(List<Reservation> reservations) {
        String url = reservationServer + "/book/v1/reservation/";
        reservations.forEach(reservation -> {
            restTemplate.delete(url + Long.toString(reservation.getId()));
        });
    }

    public List<Reservation> getByRoomId(Long id) {
        String url = reservationServer + "/book/v1/reservation/room/" + Long.toString(id);
        ResponseEntity<List<Reservation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Reservation>>() {
                });
        log.info("{}", response);
        return response.getBody();
    }

    public List<Reservation> getByHomeId(Long id) {
        String url = reservationServer + "/book/v1/reservation/home/" + Long.toString(id);
        ResponseEntity<List<Reservation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Reservation>>() {
                });
        log.info("{}", response);
        return response.getBody();
    }

    public int getHeadCount(ReservationHeadCountDto reservationHeadCountDto) {
        String url = reservationServer + "/book/v1/reservation/head_count";
        int headCount = restTemplate.postForObject(url, reservationHeadCountDto, int.class);
        log.info("{}", headCount);
        return headCount;
    }
}
