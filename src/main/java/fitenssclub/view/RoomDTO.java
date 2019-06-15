package fitenssclub.view;

import fitenssclub.model.activities.Room;

class RoomDTO {

    final Room room;

    RoomDTO(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return room.getNumber() + " (" + room.getCapasity() + ")";
    }
}
