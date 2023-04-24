package Builder.template;

import java.util.ArrayList;

public class Product {
    private ArrayList<String> parts = new ArrayList<>();

    public void Add(String part)
    {
        parts.add(part);
    }

    public void Show()
    {
        for (String str:parts) {
            System.out.println(str);
        }
    }
}
