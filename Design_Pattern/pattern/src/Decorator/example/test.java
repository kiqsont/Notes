package Decorator.example;

public class test {
    public static void main(String[] args) {
        People people = new People("kiqsont");
        BigTrouser bigTrouser1 = new BigTrouser();
        LeatherShoes leatherShoes1 = new LeatherShoes();
        Sneakers sneakers1 = new Sneakers();

        System.out.println("Decorator1");
        bigTrouser1.setDecorator(people);
        leatherShoes1.setDecorator(bigTrouser1);
        sneakers1.setDecorator(leatherShoes1);
        sneakers1.show();

        System.out.println("\nDecorator2");
        Tie tie = new Tie();
        TShirts tShirts = new TShirts();
        tie.setDecorator(people);
        tShirts.setDecorator(tie);
        tShirts.show();
    }
}
