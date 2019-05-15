package fitenssclub.users.worker.form;

import java.io.Serializable;

public class B2B extends WorkForm implements Serializable {

    B2B(){}

    @Override
    public String getWorkFormName() {
        return "Business2Business";
    }
}
