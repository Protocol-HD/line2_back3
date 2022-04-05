package line2.line2_back3.home.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeListDto {
    private Long homeId;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    private Long homeCategoryId;
    private String image;
    private List<Long> homeFacilities;
}
