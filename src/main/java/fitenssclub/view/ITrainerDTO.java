package fitenssclub.view;

import fitenssclub.model.users.User;
import fitenssclub.model.users.worker.roles.ITrainer;

/**
 * DTO - Klasa transferu danych
 * Klasa przechowująca uproszczone informacje o trenerze (prostrzy toString() dla JChooser)
 */
class ITrainerDTO {
    final ITrainer trainer;

    ITrainerDTO(ITrainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        User user = ((User) trainer);
        return user.getFirstName() + " " + user.getLastName() + " " + trainer.getSpecializations().toString();
    }
}
