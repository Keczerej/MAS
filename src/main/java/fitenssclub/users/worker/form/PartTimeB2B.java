package fitenssclub.users.worker.form;

import java.io.Serializable;

public class PartTimeB2B extends WorkForm implements Serializable, PartTimeWorkForm {

    PartTimeB2B(){}

    @Override
    public String getWorkFormName() {
        return "Business2Business. Liczba dni: " + this.getNumberOfDaysAtWeek();
    }

    @Override
    public double getSalaryScale() {
        return WorkForm.B2B.getSalaryScale() * (getNumberOfDaysAtWeek()/5.0);
    }
}
