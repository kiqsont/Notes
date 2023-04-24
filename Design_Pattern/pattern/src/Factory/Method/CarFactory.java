package Factory.Method;

public class CarFactory {
    public static CarInterface factoryGetCar(String carName)
    {
        if(carName.equals("AE86"))
        {
            return new AE86();
        }
        else if(carName.equals("WuLing"))
        {
            return new WuLing();
        }

        return null;
    }
}
