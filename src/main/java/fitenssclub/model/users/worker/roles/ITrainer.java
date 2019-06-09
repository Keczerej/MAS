package fitenssclub.model.users.worker.roles;

import fitenssclub.model.users.worker.form.WorkForm;

import java.util.Set;

public interface ITrainer {

    Set<String> getSpecializations();

    default void addSpecialization(String specialisation) {
        getSpecializations().add(specialisation);
    }

    default void removeSpecialization(String specialisation) {
        getSpecializations().remove(specialisation);
    }

    default int getSalary(WorkForm workForm) {
        double scale = workForm.getSalaryScale();
        return (int)(3000 * scale);
    }

    default String specialisationsString() {
        return " -> Specialisations: " +  getSpecializations().toString();
    }

}
