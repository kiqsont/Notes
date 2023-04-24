package Command;

public class BakeChickenWingCommand extends Command{
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void ExecuteCommand() {
        receiver.BakeChickenWing();
    }
}
