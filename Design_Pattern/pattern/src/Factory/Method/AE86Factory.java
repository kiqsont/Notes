package Factory.Method;

public class AE86Factory implements CarFactoryInterface{
    @Override
    public CarInterface GetCar() {
        return new AE86();
    }
}
