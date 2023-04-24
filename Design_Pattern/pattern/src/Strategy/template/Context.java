package Strategy.template;

public class Context {
    StrategyClass strategy;

    public Context(StrategyClass strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(StrategyClass strategy) {
        this.strategy = strategy;
    }

    public void ContextInterface()
    {
        this.strategy.AlgorithmInterface();
    }
}
