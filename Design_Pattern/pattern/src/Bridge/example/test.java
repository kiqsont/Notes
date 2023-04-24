package Bridge.example;

public class test {
    public static void main(String[] args) {
        HandsetBrand ab;
        ab = new HandsetBrandN();

        ab.setSoft(new HandsetGame());
        ab.Run();

        ab.setSoft(new HandsetAddressList());
        ab.Run();

        System.out.println("------------------");

        ab = new HandsetBrandM();
        ab.setSoft(new HandsetGame());
        ab.Run();

        ab.setSoft(new HandsetAddressList());
        ab.Run();

    }
}
