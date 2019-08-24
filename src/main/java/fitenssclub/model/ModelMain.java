package fitenssclub.model;

import fitenssclub.database.Database;
import fitenssclub.model.activities.*;
import fitenssclub.model.users.client.Client;
import fitenssclub.model.users.worker.form.WorkForm;
import fitenssclub.model.users.worker.roles.Manager;
import fitenssclub.model.users.worker.roles.Trainer;
import fitenssclub.model.users.worker.roles.TrainerReceptionist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class ModelMain {

    public static void main(String[] argv) {
        if(argv[0].equals("write")){
            createDatabase(argv[1]);
        }
        if(argv[0].equals("read")){
            readFromDatabase(argv[1]);
        }
    }

    private static void readFromDatabase(String fileName) {
        Database.readFromPath(fileName);
        readDbState();
    }

    private static void readDbState() {
        System.out.println("\n\n### Stan bazy danych w pamięci podręcznej.");

        System.out.println("\n# Czytam użytkowników");
        Database.getUsers()
                .iterator()
                .forEachRemaining(System.out::println);
        System.out.println("\n# Czytam aktywności");
        Database.getActivities()
                .iterator()
                .forEachRemaining(System.out::println);
        System.out.println("\n# Czytam ćwiczenia");
        Database.getExercises()
                .iterator()
                .forEachRemaining(System.out::println);
        System.out.println("\n# Czytam pokoje");
        Database.getRooms()
                .iterator()
                .forEachRemaining(System.out::println);
    }

    private static void createDatabase(String filesPath) {
        System.out.println("## Dodaję dane do pliku " + filesPath + "\n\n");
        Client client = new Client(
                "keczerej",
                "trudneHaslo",
                "Piotr",
                "Jereczek",
                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );//Kompozycja
        System.out.println("1. Dodany klient");
        System.out.println(client);

        Set<String> specialisations = new HashSet<>();
        specialisations.add("Karate");
        Trainer trainer = new Trainer(
                "a.kowal",
                "trudneHasl2o",
                "Adam",
                "Kowalski",
                "Warszawa",
                "Ul. Szkolna 13",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                specialisations
        );
        System.out.println("\n2. Dodany trener");
        System.out.println(trainer);
        System.out.println("Płaca: " + trainer.getSalary());
        System.out.println("Forma zatrudnienia: " + trainer.getWorkFormName());

        Room r106 = new Room("p106", 10);
        Activity activity = new Activity("Joga", LocalDateTime.now(), trainer, r106);
        Exercise joga = new Exercise("pompki", EnumSet.of(ExerciseType.Strength));
        Equipment kula = new Equipment("kula");
        Equipment hantle = new Equipment("hantle");
        joga.addEquipment(kula); //Zwykła
        joga.addEquipment(hantle);
        activity.addExercise(joga, 10); //Z atrybutem
        activity.addContributor(client); //Kwalifikowana
        System.out.println("\n3. Dodane zajecia");
        System.out.println(activity);
        System.out.println("\n3a. Czas zajęć");
        System.out.println(activity.getExercisesTime() + " minut");
        System.out.println("\n4. Klient po dodaniu do zajęć");
        System.out.println(client);

        System.out.println("\n5.Trener po dodaniu obowiązków recepcionisty + dodaniu specializacji w Fitniessie");
        TrainerReceptionist changedTrainerToReceptionist = new TrainerReceptionist(trainer);
        changedTrainerToReceptionist.addSpecialization("Fitness");
        System.out.println(changedTrainerToReceptionist);
        System.out.println("Płaca: " + changedTrainerToReceptionist.getSalary());
        System.out.println("Forma zatrudnienia: " + changedTrainerToReceptionist.getWorkFormName());

        System.out.println("\n6.Trener po zmianie roli na menadżera.");
        Manager changedTrainerToManager = new Manager(changedTrainerToReceptionist);
        System.out.println(changedTrainerToManager);
        System.out.println("Płaca: " + changedTrainerToManager.getSalary());
        System.out.println("Forma zatrudnienia: " + changedTrainerToManager.getWorkFormName());

        System.out.println("\n7.Trener po zmianie formy zatrudnienia na B2B.");
        WorkForm.createB2B(changedTrainerToManager);
        System.out.println(changedTrainerToManager);
        System.out.println("Płaca: " + changedTrainerToManager.getSalary());
        System.out.println("Forma zatrudnienia: " + changedTrainerToManager.getWorkFormName());

        System.out.println("\n8. Klient po tym - jak trener nie jest już trenerem (zajęcia odwołane)");
        System.out.println(client);

        System.out.println("9. Dodanie nowego trenera i przypisanie go do nowej aktyrwności");

        Set<String> newSpecialisations = new HashSet<>();
        newSpecialisations.add("Pilates");

        Trainer bartek = new Trainer(
                "bartek",
                "trudneHasl2o",
                "Bartek",
                "Kowalski",
                "Gdańsk",
                "Ul. Szkolna 13",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                newSpecialisations
        );

        newSpecialisations.add("Joga");

        new Trainer(
                "pawel",
                "trudneHasl2o",
                "Paweł",
                "Nowak",
                "Gdańsk",
                "Ul. Szkolna 13",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                newSpecialisations
        );


        Activity newActivity = new Activity("Nowe zajęcia", LocalDateTime.now(), bartek, new Room("p107", 30));
        newActivity.addContributor(client);
        newActivity.addExercise(joga, 20);
        System.out.println(bartek);
        System.out.println(client);
        System.out.println(newActivity);

        additionalEntities(specialisations);

        Database.writeToPath(filesPath);
        readDbState();
    }

    private static void additionalEntities(Set<String> specialisations) {

        new Trainer(
                "artur",
                "trudneHasl2o",
                "Artur",
                "Nowak",
                "Gdańsk",
                "Ul. Szkolna 13",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                specialisations
        );

        //Adding some exercises
        new Exercise("bieganie", EnumSet.of(ExerciseType.Aerobic));
        new Exercise("skakanie", EnumSet.of(ExerciseType.Aerobic));
        new Exercise("pajacyki", EnumSet.of(ExerciseType.Aerobic));
        new Exercise("fikołki", EnumSet.of(ExerciseType.Aerobic));
        new Exercise("rozciąganie", EnumSet.of(ExerciseType.Aerobic));
        new Exercise("piłka", EnumSet.of(ExerciseType.Aerobic));


        new Room("p101a", 15);
        new Room("p107", 20);
    }

}
