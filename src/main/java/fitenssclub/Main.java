package fitenssclub;

import fitenssclub.activities.Activity;
import fitenssclub.activities.exercise.Equipment;
import fitenssclub.activities.exercise.Exercise;
import fitenssclub.activities.exercise.Relax;
import fitenssclub.activities.exercise.Strength;
import fitenssclub.users.User;
import fitenssclub.users.client.Client;
import fitenssclub.users.worker.form.WorkForm;
import fitenssclub.users.worker.roles.Manager;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] argv) {

        String fileName = "users.fc";

        if(new File(fileName).exists())
            User.readFromFile(fileName);


        new Client(
                "keczerej",
                "trudneHaslo",
                "Piotr",
                "Jereczek",
               "Legionowo",
                "Ul. Krasnoludzka 32A",
                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        new Manager(
                "a.kowal",
                "trudneHasl2o",
                "Adam",
                "Kowalski",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                WorkForm.B2B
        );

        User.writeToFile(fileName);

        User.getUsers()
                .iterator()
                .forEachRemaining(System.out::println);


        Exercise joga = new Strength("pompki");
        Equipment kula = new Equipment("kula");
        Equipment hantle = new Equipment("hantle");
        joga.addEquipment(kula);
        joga.addEquipment(hantle); //pomyłka
        System.out.println("[Joga] Przed pomyłką");
        System.out.println(joga);
        joga.getEquipmentList().remove(hantle); //usuwamy pomyłkę
        System.out.println("[Joga] Po pomyłce");
        System.out.println(joga);


    }

}
