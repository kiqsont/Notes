package Builder.template;

public class Director {
    Builder builder;

    public void useBuilder(Builder builder)
    {
        builder.BuildPartA();
        builder.BuildPartB();
    }
}
