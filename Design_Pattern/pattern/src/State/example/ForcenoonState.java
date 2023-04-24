package State.example;

public class ForcenoonState extends State{
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 12)
        {
            System.out.println("Force noon State " + work.getHour());
        }
        else
        {
            work.setState(new NoonState());
            work.WriteProgram();
        }
    }
}
