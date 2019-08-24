package fitenssclub.view;

import fitenssclub.model.activities.Activity;
import fitenssclub.model.users.User;

import java.time.LocalDateTime;

class ActivityItemDTO {

    final String name;
    final String from;
    final String to;
    final String room;
    final String trainer;

    ActivityItemDTO() {
        this.name = "Nazwa";
        this.from = "Od kiedy";
        this.to = "Do kiedy";
        this.room = "Pokój";
        this.trainer = "Trener";
    }

    ActivityItemDTO(Activity activity) {
        this.name = activity.getName();
        this.from = toDateString(activity.getDate());
        this.to = toDateString(activity.getDate().plusMinutes(activity.getExercisesTime()));
        this.room = activity.getRoom().getNumber();
        User user = ((User) activity.getTrainer());
        this.trainer = user.getFirstName() + " " + user.getLastName();
    }

    private String toDateString(LocalDateTime localDateTime) {
        return localDateTime.toString().replace("T", " ").substring(0, 16);
    }

}
