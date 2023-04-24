package Composite.template;

import java.util.ArrayList;

public class Composite extends Component{

    private ArrayList<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void Add(Component c) {
        children.add(c);
    }

    @Override
    public void Remove(Component c) {
        children.remove(c);
    }

    @Override
    public void Display(int depth) {
        System.out.println(getPrefix(depth) + name);
        for(Component component : children)
        {
            component.Display(depth + 1);
        }
    }
}
