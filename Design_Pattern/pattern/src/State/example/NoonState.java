package State.example;

public class NoonState extends State{
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 13)
        {
            System.out.println("Lunch State " + work.getHour());
        }
        else
        {
            work.setState(new AfternoonState());
            work.WriteProgram();
        }
    }
}
