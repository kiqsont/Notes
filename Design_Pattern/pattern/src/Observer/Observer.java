package Observer;

public abstract class Observer {

    protected Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public abstract void Update();
}
