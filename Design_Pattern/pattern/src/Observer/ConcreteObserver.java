package Observer;

public class ConcreteObserver extends Observer{

    private String workerName;
    private String SubjectMsg;

    public ConcreteObserver(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public void Update() {
        if(subject != null)
            SubjectMsg = subject.getSubjectMsg();
        System.out.println(workerName + " has received " + SubjectMsg);
    }
}
