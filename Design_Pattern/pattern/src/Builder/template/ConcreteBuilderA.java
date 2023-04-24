package Builder.template;

public class ConcreteBuilderA extends Builder{

    Product product = new Product();

    @Override
    public void BuildPartA() {
        product.Add("Build partA in BuilderA");
    }

    @Override
    public void BuildPartB() {
        product.Add("Build partB in BuilderA");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
