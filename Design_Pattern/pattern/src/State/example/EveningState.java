package State.example;

public class EveningState extends State{
    @Override
    public void WriteProgram(Work work) {
        if(work.isFinish())
        {
            work.setState(new RestState());
            work.WriteProgram();
        }
        else
        {
            if(work.getHour() < 21)
            {
                System.out.println("Overwork and feel tired " + work.getHour());
            }
            else
            {
                work.setState(new SleepingState());
                work.WriteProgram();
            }
        }
    }
}
