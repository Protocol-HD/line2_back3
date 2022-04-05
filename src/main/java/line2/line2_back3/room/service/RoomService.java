package line2.line2_back3.room.service;

import line2.line2_back3.room.model.Room;

public interface RoomService {
    Room save(Room room);

    void deleteById(Long id);

    Room findById(Long id);
}
