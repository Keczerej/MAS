package fitenssclub.users.worker.form;

import java.io.Serializable;

public abstract class WorkForm implements WorkFormInterface, Serializable {

    public static WorkForm B2B = new B2B();
    public static WorkForm UOP = new UoP();
    public static WorkForm PartTimeB2B = new PartTimeB2B();
    public static WorkForm PartTimeUOP = new PartTimeUoP();

    @Override
    public abstract String getWorkFormName();

    public abstract double getSalaryScale();
}
