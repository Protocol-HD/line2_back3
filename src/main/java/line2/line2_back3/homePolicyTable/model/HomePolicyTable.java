package line2.line2_back3.homePolicyTable.model;

import lombok.*;

import javax.persistence.*;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.homePolicy.model.HomePolicy;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomePolicyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "home_policy_id")
    private HomePolicy homePolicy;
}
