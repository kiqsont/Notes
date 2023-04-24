package State.example;

public class RestState extends State{
    @Override
    public void WriteProgram(Work work) {
        System.out.println("Get off work " + work.getHour());
    }
}
