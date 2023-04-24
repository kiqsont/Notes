package State.example;

public class SleepingState extends State{
    @Override
    public void WriteProgram(Work work) {
        System.out.println("Too tired to sleep " + work.getHour());
    }
}
