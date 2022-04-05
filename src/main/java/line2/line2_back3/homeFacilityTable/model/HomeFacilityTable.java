package line2.line2_back3.homeFacilityTable.model;

import lombok.*;

import javax.persistence.*;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.homeFacility.model.HomeFacility;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeFacilityTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "home_facility_id")
    private HomeFacility homeFacility;
}
