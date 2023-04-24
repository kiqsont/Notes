package Observer;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    private String SubjectMsg;

    public String getSubjectMsg() {
        return SubjectMsg;
    }

    public void setSubjectMsg(String subjectMsg) {
        SubjectMsg = subjectMsg;
    }


    public void Append(Observer observer)
    {
        observers.add(observer);
        observer.setSubject(this);
    }

    public void Remove(Observer observer)
    {
        observers.remove(observer);
        observer.setSubject(null);
    }

    public void Notify()
    {
        for (Observer observer:observers
             ) {
            observer.Update();
        }
    }
}
