package line2.line2_back3.restApi.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    private Long id;
    private Long homeId;
    private Long roomId;
    private Long userId;
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
