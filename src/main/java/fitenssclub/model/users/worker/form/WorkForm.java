package fitenssclub.model.users.worker.form;

import fitenssclub.model.users.worker.Worker;

import java.io.Serializable;

public abstract class WorkForm implements Serializable {

    //MP03 4. Dziedziczenie wieloaspektowe - rozwiązanie nr. 2 z kompozycją
    private final Worker worker;

    public static WorkForm createB2B(Worker worker) {
        validateWorkerNotNull(worker);
        WorkForm workForm = new B2B(worker);
        worker.setWorkForm(workForm);
        return workForm;
    }

    public static WorkForm createUoP(Worker worker) {
        validateWorkerNotNull(worker);
        WorkForm workForm = new UoP(worker);
        worker.setWorkForm(workForm);
        return workForm;
    }

    private static void validateWorkerNotNull(Worker worker) {
        if(worker == null) throw new IllegalArgumentException("Worker can't be null");
    }

    WorkForm(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public abstract String getWorkFormName();

    public abstract double getSalaryScale();

    abstract public <T extends Worker> WorkForm cloneIntoWorker(T worker);

}

class B2B extends WorkForm implements Serializable {

    B2B(Worker worker) {
        super(worker);
    }

    @Override
    public String getWorkFormName() {
        return "Business2Business";
    }

    @Override
    public double getSalaryScale() {
        return 1.3;
    }

    @Override
    public <T extends Worker> WorkForm cloneIntoWorker(T worker) {
        return WorkForm.createB2B(worker);
    }
}

class UoP extends WorkForm implements Serializable {

    UoP(Worker worker) {
        super(worker);
    }

    @Override
    public String getWorkFormName() {
        return "Umowa o pracę";
    }

    @Override
    public double getSalaryScale() {
        return 1;
    }

    @Override
    public <T extends Worker> WorkForm cloneIntoWorker(T worker) {
        return WorkForm.createUoP(worker);
    }
}



