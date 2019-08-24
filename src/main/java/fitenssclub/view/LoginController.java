package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.users.worker.roles.Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LoginController {

    /**
     * Domyślnie pobierany jest pierwszy menadzer z listy, jeżeli nie istnieje to zostaje utworzony nowy - domyślny
     *
     * @return zwraca zalogowanego menadżera
     */
    static Manager getLoggedManager() {
        return (Manager) Database
                .getUsers()
                .stream()
                .filter(it -> it instanceof Manager)
                .findAny()
                .orElseGet(() -> new Manager(
                                "keczerej",
                                "keczerej",
                                "Piotr",
                                "Jereczek",
                                "Legionowo",
                                "Górnośląska",
                                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        )
                );
    }

}
