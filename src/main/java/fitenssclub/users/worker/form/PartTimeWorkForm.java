package fitenssclub.users.worker.form;

import java.io.Serializable;

interface PartTimeWorkForm extends Serializable {

    //MP03 3. Wielodziedziczenie
    default int getNumberOfDaysAtWeek() {
        return 3;
    }

}
