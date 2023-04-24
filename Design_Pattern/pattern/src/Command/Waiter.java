package Command;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Waiter {

    private ArrayList<Command> orders = new ArrayList<Command>();

    public void SetOrder(Command command)
    {
        orders.add(command);
    }

    public void aNotify()
    {
        for(Command command : orders)
        {
            command.ExecuteCommand();
        }
    }

    public void CancelOrder(Command command)
    {
        orders.remove(command);
    }
}
