package Strategy.example;

public class CashRebate extends CashSuper{

    private double m_discount = 1;

    public CashRebate(String m_discount) {
        this.m_discount = Double.parseDouble(m_discount);
    }

    @Override
    public double acceptCash(double money) {
        return money * m_discount;
    }
}
