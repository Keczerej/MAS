package fitenssclub.users.worker.form;

import java.io.Serializable;

public class UoP extends WorkForm implements Serializable {

    UoP(){}

    @Override
    public String getWorkFormName() {
        return "Umowa o pracę";
    }

    @Override
    public double getSalaryScale() {
        return 1;
    }
}
