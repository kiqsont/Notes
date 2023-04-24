package Command;

public class BakeMuttonCommand extends Command{
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void ExecuteCommand() {
        receiver.BakeMutton();
    }
}
