package Factory.AbstractFactory.example.pojo;

public class Department {
    private int id;
    private String departName;

    public Department(int id, String departName) {
        this.id = id;
        this.departName = departName;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}

