package Factory.Method;

public class Consumer {
    public static void main(String[] args) {
        CarInterface car1 = new WuLingFactory().GetCar();
        CarInterface car2 = new AE86Factory().GetCar();
        car1.Run();
        car2.Run();
    }
}
