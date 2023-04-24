package Command;

public class test {
    public static void main(String[] args) {
        Barbecuer worker = new Barbecuer();
        Command bakeCommand1 = new BakeMuttonCommand(worker);
        Command bakeCommand2 = new BakeMuttonCommand(worker);
        Command bakeCommand3 = new BakeChickenWingCommand(worker);

        Waiter waiter = new Waiter();
        waiter.SetOrder(bakeCommand1);
        waiter.SetOrder(bakeCommand2);

        waiter.aNotify();
        System.out.println("----------------------");

        waiter.SetOrder(bakeCommand3);
        waiter.aNotify();
        System.out.println("----------------------");

        waiter.CancelOrder(bakeCommand1);
        waiter.aNotify();
    }
}
