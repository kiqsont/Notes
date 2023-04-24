package Builder.template;

public class ConcreteBuilderB extends Builder{

    Product product = new Product();

    @Override
    public void BuildPartA() {
        product.Add("Build partA in BuilderB");
    }

    @Override
    public void BuildPartB() {
        product.Add("Build partB in BuilderB");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
