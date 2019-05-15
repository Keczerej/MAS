package fitenssclub.activities;

import fitenssclub.users.client.Client;
import fitenssclub.users.worker.roles.Trainer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Activity implements Serializable {

    private String name;
    private LocalDateTime date;
    private Trainer trainer;

    private Map<String, Client> contributors = new HashMap<>();

    public Activity(String name, LocalDateTime date, Trainer trainer) {
        this.name = name;
        this.date = date;
        this.trainer = trainer;
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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}

