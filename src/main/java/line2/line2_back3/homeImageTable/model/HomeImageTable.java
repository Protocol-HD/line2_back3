package line2.line2_back3.homeImageTable.model;

import lombok.*;

import javax.persistence.*;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.image.model.Image;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeImageTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
