package line2.line2_back3.home.model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import line2.line2_back3.homeCategory.model.HomeCategory;
import line2.line2_back3.restApi.models.User;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Home {
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String homeZipCode;
    @ColumnDefault("true")
    private boolean status;
}
