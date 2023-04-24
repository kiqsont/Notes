package Flyweight.template;

import java.util.Hashtable;

public class FlyweightFactory {
    private Hashtable<String,Flyweight> flyweights = new Hashtable<>();

    public FlyweightFactory()
    {
        flyweights.put("X",new ConcreteFlyweight());
        flyweights.put("Y",new ConcreteFlyweight());
        flyweights.put("Z",new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key)
    {
        if(!flyweights.containsKey(key))
        {
            flyweights.put(key,new ConcreteFlyweight());
        }
        return flyweights.get(key);
    }
}
