package fitenssclub;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] argv) throws IOException, ClassNotFoundException {

        String fileName = "users.fc";

        if(new File(fileName).exists())
            User.readFromFile(fileName);

        //Tworzenie uzytkownika 1
        new User(
                "keczerej",
                "Piotr",
                "Jereczek",
                "trudneHaslo",
                new Address("Legionowo", "Ul. Krasnoludzka 32A"),
                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        //Tworzenie uzytkownika 2
        new User(
                "a.kowal",
                "Adam",
                "Kowalski",
                "trudneHasl2o",
                LocalDate.parse("16-05-1999", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        User.writeToFile(fileName);

        User.getUsers().iterator().forEachRemaining(System.out::println);
    }

}
