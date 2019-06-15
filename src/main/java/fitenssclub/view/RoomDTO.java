package fitenssclub.view;

import fitenssclub.model.activities.Room;

/**
 * DTO - Klasa transferu danych
 * Klasa przechowująca uproszczone informacje o sali (prostrzy toString() dla JChooser)
 */
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
