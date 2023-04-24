package Strategy.example;

public class CashContext {
    CashSuper cashSuper;

    public CashContext() {
    }

    public CashContext(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public void setCashSuper(CashSuper cashSuper) {
        this.cashSuper = cashSuper;
    }

    public double cashCount(double money)
    {
        return cashSuper.acceptCash(money);
    }
}
