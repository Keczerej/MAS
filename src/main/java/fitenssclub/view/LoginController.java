package fitenssclub.view;

import fitenssclub.database.Database;
import fitenssclub.model.users.worker.roles.Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa, która zwraca informację o zalogowanym menadżerze
 */
class LoginController {

    private static Manager loggedManager = null;

    /**
     * Domyślnie pobierany jest ostatni menadzer z listy, jeżeli nie istnieje to zostaje utworzony nowy - domyślny
     *
     * @return zwraca zalogowanego menadżera
     */
    static Manager getLoggedManager() {
        if(loggedManager == null) {
            List<Manager> managers = Database
                    .getUsers()
                    .stream()
                    .filter(it -> it instanceof Manager)
                    .map(it -> (Manager) it)
                    .collect(Collectors.toList());
            if(managers.isEmpty()){
                    LoginController.loggedManager = new Manager(
                                "keczerej",
                                "keczerej",
                                "Piotr",
                                "Jereczek",
                                "Legionowo",
                                "Górnośląska",
                                LocalDate.parse("16-07-1976", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        );
            } else {
                LoginController.loggedManager = managers.get(managers.size() - 1);
            }
        }
        return LoginController.loggedManager;
    }

}
