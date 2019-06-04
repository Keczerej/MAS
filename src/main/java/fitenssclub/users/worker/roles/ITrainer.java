package fitenssclub.users.worker.roles;

import fitenssclub.users.worker.form.WorkForm;

import java.util.HashSet;
import java.util.Set;

public interface ITrainer {

    Set<String> specializations = new HashSet<>();

    default Set<String> getSpecializations() {
        return specializations;
    }

    default void addSpecialization(String specialisation) {
        specializations.add(specialisation);
    }

    default void removeSpecialization(String specialisation) {
        specializations.remove(specialisation);
    }

    default int getSalary(WorkForm workForm) {
        double scale = workForm.getSalaryScale();
        return (int)(3000 * scale);
    }

    default String specialisationsString() {
        return " -> Specialisations: " +  getSpecializations().toString();
    }

}
