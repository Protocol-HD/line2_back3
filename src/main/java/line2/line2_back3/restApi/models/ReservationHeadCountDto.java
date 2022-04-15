package line2.line2_back3.restApi.models;

import lombok.*;

import java.util.Date;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationHeadCountDto {
    private Long roomId;
    private Date checkIn;
    private Date checkOut;
}