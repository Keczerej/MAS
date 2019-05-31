package fitenssclub.users.worker.form;

import java.io.Serializable;

public class PartTimeUoP extends WorkForm implements Serializable, PartTimeWorkForm {

    PartTimeUoP(){}

    @Override
    public String getWorkFormName() {
        return "Umowa o pracę. Liczba dni: " + this.getNumberOfDaysAtWeek();
    }

    @Override
    public double getSalaryScale() {
        return WorkForm.UOP.getSalaryScale() * (getNumberOfDaysAtWeek()/5.0);
    }
}
