package Flyweight.example;

public class test {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite fk = factory.getWebSite("Product");
        fk.Use(new User("kk"));

        WebSite fx = factory.getWebSite("Product");
        fx.Use(new User("xixi"));

        WebSite fa = factory.getWebSite("Unknown");
        fa.Use(new User("another"));

        System.out.println(factory.getWebSiteCount());

    }
}
