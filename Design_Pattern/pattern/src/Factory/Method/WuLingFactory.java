package Factory.Method;

public class WuLingFactory implements CarFactoryInterface{
    @Override
    public CarInterface GetCar() {
        return new WuLing();
    }
}
