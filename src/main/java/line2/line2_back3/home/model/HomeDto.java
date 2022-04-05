package line2.line2_back3.home.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import line2.line2_back3.room.model.Room;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeDto {
    private Long homeId;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    private Long homeCategoryId;
    private String homeInformation;
    private Long userId;
    private String homeZipCode;
    private List<String> images;
    private List<Long> homePolicies;
    private String homePolicyCustom;
    private List<Long> homeFacilities;
    private List<Room> rooms;
}
