package Composite.template;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void Add(Component c);
    public abstract void Remove(Component c);
    public abstract void Display(int depth);

    public String getPrefix(int depth)
    {
        String str = new String("-");
        for(int i = 1;i < depth;i++)
        {
            str += "--";
        }
        return str;
    }
}
