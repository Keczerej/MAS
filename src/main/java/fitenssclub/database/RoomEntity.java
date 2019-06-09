package fitenssclub.database;

import fitenssclub.model.activities.Room;

public class RoomEntity extends DatabaseEntity<Room> {

    private RoomEntity(){}

    private static RoomEntity instance = null;

    public static RoomEntity getInstance() {
        if(instance == null)
            instance = new RoomEntity();
        return instance;
    }

}
