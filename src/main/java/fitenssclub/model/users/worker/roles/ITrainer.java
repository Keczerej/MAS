package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.form.WorkForm;

import java.util.Set;

public interface ITrainer {

    /**
     * @return Lista specjalizacji danego trenera
     */
    Set<String> getSpecializations();

    /**
     * Dodanie specjalizacji do trenera
     *
     * @param specialisation nowa specjalizacja
     */
    default void addSpecialization(String specialisation) {
        getSpecializations().add(specialisation);
    }

    /**
     * Usuwa specjalizacje (ignoruje gdy nie ma jej na liście)
     *
     * @param specialisation specjalizacja do usuniecia
     */
    default void removeSpecialization(String specialisation) {
        getSpecializations().remove(specialisation);
    }

    /**
     * Wylicza pensję
     *
     * @param workForm Forma zatrudnienia
     * @return pensję z uwględnieniem formy zatrudnienia
     */
    default int getSalary(WorkForm workForm) {
        double scale = workForm.getSalaryScale();
        return (int)(3000 * scale);
    }

    default String specialisationsString() {
        return " -> Specialisations: " +  getSpecializations().toString();
    }

}
