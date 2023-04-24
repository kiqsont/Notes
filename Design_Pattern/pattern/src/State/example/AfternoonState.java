package State.example;

public class AfternoonState extends State{
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 17)
        {
            System.out.println("Afternoon State,a little tired + " + work.getHour());
        }
        else
        {
            work.setState(new EveningState());
            work.WriteProgram();
        }
    }
}
