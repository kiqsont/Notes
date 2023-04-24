package Strategy.example;

public class test {
    public static void main(String[] args) {
        double price = 123.45;
        CashContext context = new CashContext();

        context.setCashSuper(new CashNormal());
        System.out.println("Normal:" + context.cashCount(price));

        context.setCashSuper(new CashRebate("0.8"));
        System.out.println("Rebate:" + context.cashCount(price));

        context.setCashSuper(new CashReturn("50","10"));
        System.out.println("Return:" + context.cashCount(price));
    }
}
