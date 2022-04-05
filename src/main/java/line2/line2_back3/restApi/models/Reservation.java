package line2.line2_back3.restApi.models;

import lombok.*;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.room.model.Room;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    private Long id;
    private Home home;
    private Room room;
    private User user;
    private Date checkIn;
    private Date checkOut;
    private String checkInMessage;
    private String checkOutMessage;
    private String denyMessage;
    private String guestToHost;
    private boolean checkInStatus;
    private boolean checkOutStatus;
    private boolean denyStatus;
}
