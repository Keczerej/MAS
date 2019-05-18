package fitenssclub;

import fitenssclub.activities.Activity;
import fitenssclub.activities.Equipment;
import fitenssclub.activities.Exercise;
import fitenssclub.activities.Strength;
import fitenssclub.users.User;
import fitenssclub.users.client.Client;
import fitenssclub.users.worker.form.WorkForm;
import fitenssclub.users.worker.roles.Trainer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] argv) {
        if(argv[0].equals("write")){
            createDatabase(argv[1]);
        }
        if(argv[0].equals("read")){
            readFromDatabase(argv[1]);
        }
    }

    private static void readFromDatabase(String fileName) {
        System.out.println("## Czytam uzytkonikow z pliku " + fileName + "\n\n");
        User.readFromFile(fileName);
        User.getUsers()
                .iterator()
                .forEachRemaining(System.out::println);
    }

    private static void createDatabase(String fileName) {
        System.out.println("## Dodaję dane do pliku " + fileName + "\n\n");
        Client client = new Client(
                "keczerej",
                "trudneHaslo",
                "Piotr",
                "Jereczek",
               "Legionowo",
                "Ul. Krasnoludzka 32A",
                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );//Kompozycja
        System.out.println("1. Dodany klient");
        System.out.println(client);

        Trainer trainer = new Trainer(
                "a.kowal",
                "trudneHasl2o",
                "Adam",
                "Kowalski",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                WorkForm.B2B
        );
        System.out.println("\n2. Dodany trener");
        System.out.println(trainer);

        Activity activity = new Activity("Joga", LocalDateTime.now(), trainer);
        Exercise joga = new Strength("pompki");
        Equipment kula = new Equipment("kula");
        Equipment hantle = new Equipment("hantle");
        joga.addEquipment(kula); //Zwykła
        joga.addEquipment(hantle);
        activity.addExercise(joga, 10); //Z atrybutem
        activity.addContributors(client); //Kwalifikowana
        System.out.println("\n3. Dodane zajecia");
        System.out.println(activity);
        System.out.println("\n3a. Czas zajęć");
        System.out.println(activity.getExercisesTime() + " minut");
        System.out.println("\n4. Klient po dodaniu do zajęć");
        System.out.println(client);

        User.writeToFile(fileName);
    }

}
