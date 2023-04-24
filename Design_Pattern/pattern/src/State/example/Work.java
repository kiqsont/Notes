package State.example;

public class Work {
    private State state;
    private double hour;
    private boolean finish = false;

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isFinish() {
        return finish;
    }

    public Work()
    {
        state = new ForcenoonState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public void WriteProgram()
    {
        state.WriteProgram(this);
    }

}
