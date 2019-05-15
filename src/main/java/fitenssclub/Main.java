package fitenssclub;

import fitenssclub.users.Address;
import fitenssclub.users.User;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] argv) {

        String fileName = "users.fc";

        if(new File(fileName).exists())
            User.readFromFile(fileName);


        new User(
                "keczerej",
                "trudneHaslo",
                "Piotr",
                "Jereczek",
                new Address("Legionowo", "Ul. Krasnoludzka 32A"),
                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        new User(
                "a.kowal",
                "trudneHasl2o",
                "Adam",
                "Kowalski",
                LocalDate.parse("16-05-2001", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        User.writeToFile(fileName);

        User.getUsers()
                .iterator()
                .forEachRemaining(System.out::println);
    }

}
