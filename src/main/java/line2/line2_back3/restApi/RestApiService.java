package line2.line2_back3.restApi;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import line2.line2_back3.restApi.models.Reservation;
import line2.line2_back3.restApi.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestApiService {
    String reservationServer = "http://openjdk:8080";
    String userServer = "http://openjdk2:8080";
    // String reservationServer = "http://localhost:8080";
    // String userServer = "http://localhost:8081";

    public User getUserById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = userServer + "/user/v1/user/" + Long.toString(id);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        log.info("{}", response);
        return response.getBody();
    }

    public void deleteAllReservation(List<Reservation> reservations) {
        RestTemplate restTemplate = new RestTemplate();
        String url = reservationServer + "/book/v1/reservation/";
        reservations.forEach(reservation -> {
            restTemplate.delete(url + Long.toString(reservation.getId()));
        });
    }

    public List<Reservation> getByRoomId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = reservationServer + "/book/v1/reservation/room/" + Long.toString(id);
        ResponseEntity<List<Reservation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Reservation>>() {
                });
        log.info("{}", response);
        return response.getBody();
    }

    public List<Reservation> getByHomeId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = reservationServer + "/book/v1/reservation/home/" + Long.toString(id);
        ResponseEntity<List<Reservation>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Reservation>>() {
                });
        log.info("{}", response);
        return response.getBody();
    }
}
