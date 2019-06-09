package fitenssclub.activities;

import fitenssclub.users.client.Client;
import fitenssclub.users.worker.roles.ITrainer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Activity implements Serializable {

    private String name;
    private LocalDateTime date;
    private ITrainer trainer;
    private Room room;

    private Map<String, Client> contributors = new HashMap<>();
    List<ActivityToExercise> exercises = new ArrayList<>(); //Asocjacja z atrybutem

    public Activity(String name, LocalDateTime date, ITrainer trainer, Room room) {
        this.name = name;
        this.date = date;
        this.trainer = trainer;
        this.room = room;
        room.addActivity(this);
        activities.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Client> getContributors() {
        return new ArrayList<>(contributors.values());
    }

    public void addContributors(Client contributor) {
        Optional<Client> existing = this.getContributor(contributor.getLogin());
        existing.ifPresent(client -> this.removeContributor(client.getLogin()));
        this.contributors.put(contributor.getLogin(), contributor);
        contributor.addActivity(this);
    }

    public void addExercise(Exercise exercise, long minutes){
        new ActivityToExercise(exercise, this, minutes);
    }

    public void removeExercise(Exercise exercise){
        this.exercises.forEach(activityToExercise -> {
            if(activityToExercise.getExercise() == exercise) {
                activityToExercise.removeAssocation();
            }
        });
    }

    //asocjacja z klasyfikatorem
    public Optional<Client> getContributor(String login){
        return Optional.ofNullable(this.contributors.get(login));
    }
    public void removeContributor(String login){
        Client client = this.contributors.remove(login);
        if(client != null){
            client.removeActivity(this);
        }
    }

    public ITrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(ITrainer trainer) {
        this.trainer = trainer;
    }

    public long getExercisesTime() {
        return this.exercises.stream().mapToLong(ActivityToExercise::getMinutesForExercise).sum();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", \n\t\ttrainer=" + trainer +
                ", \n\t\texercises=" + exercises +
                '}';
    }

    public static List<Activity> getActivities() {
        return activities;
    }

    private static List<Activity> activities = new ArrayList<Activity>();

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

