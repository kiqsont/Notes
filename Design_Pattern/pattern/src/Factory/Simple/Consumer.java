package Factory.Simple;

public class Consumer {
    public static void main(String[] args) {
        CarInterface car1 = CarFactory.factoryGetCar("AE86");
        CarInterface car2 = CarFactory.factoryGetCar("WuLing");
        car1.Run();
        car2.Run();
    }
}
