package State.example;

public class test {
    public static void main(String[] args) {
        Work work = new Work();
        work.WriteProgram();

        work.setHour(11);
        work.WriteProgram();

        work.setHour(12);
        work.WriteProgram();

        work.setHour(13);
        work.WriteProgram();

        work.setHour(14);
        work.WriteProgram();

        work.setHour(17);
        work.WriteProgram();

        //work.setFinish(true);
        work.setHour(19);
        work.WriteProgram();

        work.setHour(21);
        work.WriteProgram();
    }
}
