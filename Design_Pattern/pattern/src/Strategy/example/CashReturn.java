package Strategy.example;

public class CashReturn extends CashSuper{

    private double m_condition = 0;
    private double m_return = 0;

    public CashReturn(String m_condition, String m_return) {
        this.m_condition = Double.parseDouble(m_condition);
        this.m_return = Double.parseDouble(m_return);
    }

    @Override
    public double acceptCash(double money) {
        if(money >= m_condition)
        {
            int num = (int)(money / m_condition);
            money -= num * m_return;
        }
        return money;
    }
}
