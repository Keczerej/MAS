package fitenssclub;

import fitenssclub.activities.Activity;
import fitenssclub.users.Address;
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
                new Address("Legionowo", "Ul. Krasnoludzka 32A"),
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


        Activity joga = new Activity("joga");
        joga.addEquipment("Kula");
        joga.addEquipment("Hantle"); //pomyłka
        joga.getEquipmentList().get(1).removeFromEquipmentList(); //usuwamy pomyłkę

        System.out.println(joga);

    }

}
