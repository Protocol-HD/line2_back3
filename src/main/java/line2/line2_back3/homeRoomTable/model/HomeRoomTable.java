package line2.line2_back3.homeRoomTable.model;

import lombok.*;

import javax.persistence.*;

import line2.line2_back3.home.model.Home;
import line2.line2_back3.room.model.Room;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeRoomTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
