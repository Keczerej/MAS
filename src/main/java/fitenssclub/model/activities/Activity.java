package fitenssclub.model.activities;

import fitenssclub.database.ActivityEntity;
import fitenssclub.model.users.client.Client;
import fitenssclub.model.users.worker.roles.ITrainer;
import fitenssclub.model.users.worker.roles.Manager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Klasa przechowująca informację o zajęciach
 * Stworzenie obiektu automatycznie zapisuje go w bazie danych w pamieci
 */
public class Activity implements Serializable {

    private String name;
    private LocalDateTime date;
    private ITrainer trainer;
    private Manager manager;
    private Room room;

    private Map<String, Client> contributors = new HashMap<>();

    List<ActivityToExercise> exercises = new ArrayList<>(); //Asocjacja z atrybutem

    /**
     * @param name Nazwa zajęć
     * @param date Czas rozpoczęcia
     * @param trainer Przypisany trener
     * @param manager Menadżer który zaplanował zajęcia
     * @param room Sala, w której się odbywają
     */
    public Activity(String name, LocalDateTime date, ITrainer trainer, Manager manager, Room room) {
        this.name = name;
        this.date = date;
        this.trainer = trainer;
        this.manager = manager;
        this.room = room;
        room.addActivity(this);
        ActivityEntity.getInstance().remove(this);
        ActivityEntity.getInstance().add(this);
    }

    /**
     * @return nazwa zajęć
     */
    public String getName() {
        return name;
    }

    /**
     * @param name nowa nazwa dla zajęć
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return czas rozpoczęcia
     */
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * @return lista uczestników
     */
    public List<Client> getContributors() {
        return new ArrayList<>(contributors.values());
    }

    /**
     * Dodaje nowego uczestnika (jeżeli już istnieje - to go nadpisuje)
     * @param contributor uczestnik do dodania
     */
    public void addContributor(Client contributor) {
        Optional<Client> existing = this.getContributor(contributor.getLogin());
        existing.ifPresent(client -> this.removeContributor(client.getLogin()));
        this.contributors.put(contributor.getLogin(), contributor);
        contributor.addActivity(this);
    }

    /**
     * Dodanie ćwiczenia razem z czasem
     *
     * @param exercise ćwiczenie
     * @param minutes czas trwamoa w minutach
     */
    public void addExercise(Exercise exercise, long minutes){
        new ActivityToExercise(exercise, this, minutes);
    }

    /**
     * Usuwa podane ćwiczenie z listy ćwiczeń. Ignoruje usunięcie gdy nie istanieje.
     *
     * @param exercise ćwieczenie do usunięcia
     */
    public void removeExercise(Exercise exercise){
        this.exercises.forEach(activityToExercise -> {
            if(activityToExercise.getExercise() == exercise) {
                activityToExercise.removeAssocation();
            }
        });
    }

    /**
     * Pobierz uczestnika po loginie
     *
     * @param login login uczestnika
     * @return uczestnika lub null gdy nie istnieje
     */
    //asocjacja z klasyfikatorem
    private Optional<Client> getContributor(String login){
        return Optional.ofNullable(this.contributors.get(login));
    }
    public void removeContributor(String login){
        Client client = this.contributors.remove(login);
        if(client != null){
            client.removeActivity(this);
        }
    }

    /**
     * @return przypisany trener
     */
    public ITrainer getTrainer() {
        return trainer;
    }

    /**
     * @param trainer nowy trener
     */
    public void setTrainer(ITrainer trainer) {
        this.trainer = trainer;
    }

    /**
     * @return lista ćwiczeń
     */
    public List<Exercise> getExercises() {
        return exercises.stream().map(ActivityToExercise::getExercise).collect(Collectors.toList());
    }

    /**
     * @return zwraca czas wykonywania danego ćwiczenia (0 gdy ćwiczenie nie jesy wykonywane w ramach danej aktywności)
     */
    public Long getExerciseTime(Exercise exercise) {
        return exercises
                .stream()
                .filter(it -> it.getExercise() == exercise
                ).map(ActivityToExercise::getMinutesForExercise)
                .findAny()
                .orElse(0L);
    }

    /**
     * @return zwraca sumę czasu ćwiczeń
     */
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
                ", \n\t\troom=" + room +
                '}';
    }

    /**
     * @return sala
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @param room nowa sala
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return zwraca menadżera, któy zaplanował dane zajęcia
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Ustawia nowego menadżera dla zajęć
     *
     * @param manager nowy manadżer, któy zaplanował zajęcia
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

