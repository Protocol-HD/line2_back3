package line2.line2_back3.home.model;

import lombok.*;

import javax.persistence.*;

import line2.line2_back3.checkTime.model.CheckTime;
import line2.line2_back3.homeCategory.model.HomeCategory;
import line2.line2_back3.restApi.models.User;
import line2.line2_back3.util.BaseTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Home extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String homeName;
    private String homeAddress;
    private double coordinateX;
    private double coordinateY;
    @ManyToOne
    @JoinColumn(name = "home_category_id")
    private HomeCategory homeCategory;
    private String homeInformation;
    private Long userId;
    private String homeZipCode;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "check_in_time")
    private CheckTime checkInTime;
    @ManyToOne
    @JoinColumn(name = "check_out_time")
    private CheckTime checkOutTime;
}
